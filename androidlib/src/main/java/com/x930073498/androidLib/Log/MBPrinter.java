package com.x930073498.androidLib.Log;

import android.text.TextUtils;

import com.x930073498.androidLib.Log.parser.JsonParser;
import com.x930073498.androidLib.Log.parser.ObjectParser;
import com.x930073498.androidLib.Log.parser.Parser;
import com.x930073498.androidLib.Log.parser.UrlParser;
import com.x930073498.androidLib.Log.parser.XmlParser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MBPrinter implements Printer {

    /**
     * Priority constant for the println method; use Log.v.
     */
    public static final int VERBOSE = 2;

    /**
     * Priority constant for the println method; use Log.d.
     */
    public static final int DEBUG = 3;

    /**
     * Priority constant for the println method; use Log.i.
     */
    public static final int INFO = 4;

    /**
     * Priority constant for the println method; use Log.w.
     */
    public static final int WARN = 5;

    /**
     * Priority constant for the println method; use Log.e.
     */
    public static final int ERROR = 6;

    /**
     * Priority constant for the println method.
     */
    public static final int ASSERT = 7;

    /**
     * classname.
     */
    protected static String MBLOG_CLASSNAME;

    protected static final int CHUNK_SIZE = 4000;

    protected Log.Builder logBuilder;

    public MBPrinter() {
        MBLOG_CLASSNAME = getClass().getPackage().getName();
    }

    public Log.Builder init() {
        if(logBuilder == null){
            logBuilder = new Log.Builder();
        }
        if(logBuilder.parserList  == null){
            logBuilder.parserList = new LinkedList<>();
            logBuilder.parserList.add(new JsonParser());
            logBuilder.parserList.add(new XmlParser());
            logBuilder.parserList.add(new UrlParser());
            logBuilder.parserList.add(new ObjectParser());
        }
        if(TextUtils.isEmpty(logBuilder.tag)){
            logBuilder.tag = Log.LOG_TAG_DEFUALT;
        }
        return logBuilder;
    }

    public Log.Builder getLogBuilder() {
        return logBuilder;
    }

    @Override
    public void setLastMethodClassName(String className) {
        if(TextUtils.isEmpty(className)){
            return;
        }
        MBLOG_CLASSNAME = className;
    }

    public void d(Object... args) {
        log(DEBUG, args);
    }

    public void e(Object... args){
        log(ERROR, args);
    }

    public void e(Throwable throwable, Object... args){
        if(args == null){
            return;
        }
        List<Object> list = new ArrayList<>();
        for (int i=0; i<args.length; i++) {
            list.add(args[i]);
        }
        list.add(android.util.Log.getStackTraceString(throwable));
        log(ERROR, list.toArray());
    }

    public void w(Object... args){
        log(WARN, args);
    }

    public void i(Object... args){
        log(INFO, args);
    }

    public void v(Object... args){
        log(VERBOSE, args);
    }

    public void wtf(Object... args){
        log(ASSERT, args);
    }

    protected synchronized void log(int logType, Object... args) {

        if(logBuilder == null){
            return;
        }
        if(logBuilder.printType == null){
            logBuilder.printType = Log.PRINT.MBLOG;
        }

        if(Log.PRINT.NONE == logBuilder.printType){
            return;
        } else if(Log.PRINT.SYSTEM == logBuilder.printType){
            print(logType, logBuilder.tag, getContent(args));
            return;
        }

        StringBuilder builder = new StringBuilder();
        if(Log.PRINT.MBLOG == logBuilder.printType){
            builder.append(getMethod() + "\n");
        }
        builder.append(getContent(args));
        logChunk(logType, logBuilder.tag, builder.toString());
    }

    protected String getMethod() {
        StackTraceElement[] trace = Thread.currentThread().getStackTrace();

        int stackOffset = 0;
        for (int i = trace.length - 1; i >= 0; i--) {
            if (trace[i].getClassName().indexOf(MBLOG_CLASSNAME) >= 0) {
                break;
            }
            stackOffset = i;
        }

        StringBuilder builder = new StringBuilder();
        builder.append("$ ")
                .append("(")
                .append(trace[stackOffset].getFileName())
                .append(":")
                .append(trace[stackOffset].getLineNumber())
                .append(")")
                .append(" Method: " + trace[stackOffset].getMethodName())
                .append(" Thread: " + Thread.currentThread().getName());
        return builder.toString();
    }

    protected String getContent(Object... args) {
        if (args == null || args.length == 0) {
            return null;
        }

        StringBuilder builder = new StringBuilder();
        for (Object object : args) {
            if (object == null) {
                continue;
            }
            String content = null;
            if (logBuilder.parserList != null
                    && Log.PRINT.NONE != logBuilder.printType
                    && Log.PRINT.SYSTEM != logBuilder.printType) {
                for (Parser parser : logBuilder.parserList) {
                    content = parser.parse(object);
                    if (!TextUtils.isEmpty(content)) {
                        break;
                    }
                }
            }
            builder.append(TextUtils.isEmpty(content) ? object.toString() : content);
            builder.append("\n");
        }
        return builder.toString();
    }

    protected void logChunk(int logType, String tag, String chunk) {
        byte[] bytes = chunk.getBytes();
        int length = bytes.length;
        if (length <= CHUNK_SIZE) {
            printChunk(logType, tag, chunk);
            return;
        }
        for (int i = 0; i < length; i += CHUNK_SIZE) {
            int count = Math.min(length - i, CHUNK_SIZE);
            //create a new String with system's default charset (which is UTF-8 for Android)
            printChunk(logType, tag, new String(bytes, i, count));
        }
    }

    protected void printChunk(int logType, String tag, String chunk) {
        String[] lines = chunk.split(System.getProperty("line.separator"));
        StringBuilder builder = new StringBuilder();
        for (String line : lines) {
            builder.append(line + "\n");
        }
        print(logType, tag, chunk);
    }

    protected void print(int logType, String tag, String chunk) {
        switch (logType) {
            case ERROR:
                android.util.Log.e(tag, chunk);
                break;
            case INFO:
                android.util.Log.i(tag, chunk);
                break;
            case VERBOSE:
                android.util.Log.v(tag, chunk);
                break;
            case WARN:
                android.util.Log.w(tag, chunk);
                break;
            case ASSERT:
                android.util.Log.wtf(tag, chunk);
                break;
            case DEBUG:
                // Fall through, log debug by default
            default:
                android.util.Log.d(tag, chunk);
                break;
        }
    }
}
