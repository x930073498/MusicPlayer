package com.x930073498.MusicPlayer.java.lib.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

	private static MessageDigest md5;

	static {
		synchronized (MD5Util.class) {
			if (md5 == null) {
				try {
					md5 = MessageDigest.getInstance("MD5");
				} catch (NoSuchAlgorithmException e) {
					throw new RuntimeException(e.toString());
				}

			}
		}
	}

	public static final String encodeString(String string) throws RuntimeException {
		return byteToHex(digestString(string, null));
	}

	public static final String encodeString(String string, String encoding) throws RuntimeException {
		return byteToHex(digestString(string, encoding));
	}

	public static byte[] digestString(String string, String encoding) throws RuntimeException {

		byte[] data;

		if (encoding == null) {
			encoding = "ISO-8859-1";
		}

		try {
			data = string.getBytes(encoding);
		} catch (UnsupportedEncodingException x) {
			throw new RuntimeException(x.toString());
		}

		return digestBytes(data);
	}

	public static final byte[] digestBytes(byte[] data) throws RuntimeException {
		return md5.digest(data);
	}

	private static final char HEXCHAR[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
			'f' };

	public static String byteToHex(byte b[]) {

		int len = b.length;
		char[] s = new char[len * 2];

		for (int i = 0, j = 0; i < len; i++) {
			int c = ((int) b[i]) & 0xff;

			s[j++] = HEXCHAR[c >> 4 & 0xf];
			s[j++] = HEXCHAR[c & 0xf];
		}

		return new String(s);
	}

	public static String getFileMd5(String filename) throws Exception {
		return getFileMd5(filename, null);
	}

	public static String getFileMd5(String filename, String encoding) throws Exception {
		encoding = encoding == null ? "ISO-8859-1" : encoding;
		File f = new File(filename);

		if (!f.exists()) {
			return "";
		}
		InputStream is = new FileInputStream(f);
		byte[] buffer = new byte[1024];
		MessageDigest digest = MessageDigest.getInstance("MD5");

		int count;
		while ((count = is.read(buffer)) > 0) {
			digest.update(buffer, 0, count);
		}
		byte[] md5sum = digest.digest();
		BigInteger bigInt = new BigInteger(1, md5sum);
		String output = bigInt.toString(16);

		is.close();
		return output;
	}

	public static String getFileMd5(File file) throws Exception {
		return getFileMd5(file, null);
	}

	public static String getFileMd5(File file, String encoding) throws Exception {
		encoding = encoding == null ? "ISO-8859-1" : encoding;
		InputStream is = new FileInputStream(file);
		byte[] buffer = new byte[1024];
		MessageDigest digest = MessageDigest.getInstance("MD5");

		int count;
		while ((count = is.read(buffer)) > 0) {
			digest.update(buffer, 0, count);
			
		}
		byte[] md5sum = digest.digest();
		BigInteger bigInt = new BigInteger(1, md5sum);
		String output = bigInt.toString(16);

		is.close();
		return output;
	}

	public static String getStringMD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = s.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte b = md[i];

				str[k++] = hexDigits[b >> 4 & 0xf];
				str[k++] = hexDigits[b & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("resource")
	public static String getFileMD5String(File file) throws IOException {
		FileInputStream in = new FileInputStream(file);
		FileChannel ch = in.getChannel();
		
		//700000000 bytes are about 670M
		int maxSize=18000000;
		
		long startPosition=0L;
		long step=file.length()/maxSize;
		
		if(step == 0){
			MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0,file.length());
			md5.update(byteBuffer);
			return bufferToHex(md5.digest());
		}
		
		for(int i=0;i<step;i++){
			MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, startPosition,maxSize);
			md5.update(byteBuffer);
			startPosition+=maxSize;
		}
		
		if(startPosition==file.length()){
			return bufferToHex(md5.digest());
		}

		MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, startPosition,file.length()-startPosition);
		md5.update(byteBuffer);
		
			
		return bufferToHex(md5.digest());
	}

	
	public static String getBigFileMD5String(File file) throws IOException {
		FileInputStream in = new FileInputStream(file);
		FileChannel ch = in.getChannel();
		
		long maxSize=1048576;
		
		long startPosition=0L;
		long step=file.length()/maxSize;
		
		if(step == 0){
			MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0,file.length());
			md5.update(byteBuffer);
			return bufferToHex(md5.digest());
		}
		
		for(int i=0;i<step;i++){
			MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, startPosition,16);
			md5.update(byteBuffer);
			startPosition+=maxSize;
		}
		
		if(startPosition==file.length()){
			return bufferToHex(md5.digest());
		}
		
		MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, startPosition,file.length()-startPosition);
		md5.update(byteBuffer);
		
		
		return bufferToHex(md5.digest());
	}

	
	public static String getMD5String(String s) {
		return getMD5String(s.getBytes());
	}

	public static String getMD5String(byte[] bytes) {
		md5.update(bytes);
		return bufferToHex(md5.digest());
	}

	private static String bufferToHex(byte bytes[]) {
		return bufferToHex(bytes, 0, bytes.length);
	}

	private static String bufferToHex(byte bytes[], int m, int n) {
		StringBuffer stringbuffer = new StringBuffer(2 * n);
		int k = m + n;
		for (int l = m; l < k; l++) {
			appendHexPair(bytes[l], stringbuffer);
		}
		return stringbuffer.toString();
	}

	private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
		char c0 = HEXCHAR[(bt & 0xf0) >> 4];
		char c1 = HEXCHAR[bt & 0xf];
		stringbuffer.append(c0);
		stringbuffer.append(c1);
	}

	public static boolean checkPassword(String password, String md5PwdStr) {
		String s = getMD5String(password);
		return s.equals(md5PwdStr);
	}
}
