package com.x930073498.MusicPlayer.screen.model;

import android.databinding.Bindable;
import android.databinding.ObservableArrayList;

import com.alibaba.fastjson.annotation.JSONField;
import com.x930073498.MusicPlayer.BR;
import com.x930073498.MusicPlayer.core.mvvm.IData;

/**
 * Created by x930073498 on 17-5-16.
 */

public class SearchSongResult extends IData {
    @JSONField(name = "xiami")
    private XiamiSource sourceFromXiami;
    @JSONField(name = "qq")
    private OtherSource sourceFromQQ;
    @JSONField(name = "netease")
    private OtherSource sourceFromNetease;

    @Bindable
    public XiamiSource getSourceFromXiami() {
        return sourceFromXiami;
    }

    public void setSourceFromXiami(XiamiSource sourceFromXiami) {
        this.sourceFromXiami = sourceFromXiami;
        notifyPropertyChanged(BR.sourceFromXiami);
    }

    @Bindable
    public OtherSource getSourceFromQQ() {
        return sourceFromQQ;
    }

    public void setSourceFromQQ(OtherSource sourceFromQQ) {
        this.sourceFromQQ = sourceFromQQ;
        notifyPropertyChanged(BR.sourceFromQQ);
    }

    @Bindable
    public OtherSource getSourceFromNetease() {
        return sourceFromNetease;
    }

    public void setSourceFromNetease(OtherSource sourceFromNetease) {
        this.sourceFromNetease = sourceFromNetease;
        notifyPropertyChanged(BR.sourceFromNetease);
    }

    @Override
    public String toString() {
        return "SearchSongResult{" +
                "sourceFromXiami=" + sourceFromXiami +
                ", sourceFromQQ=" + sourceFromQQ +
                ", sourceFromNetease=" + sourceFromNetease +
                '}';
    }

    public static class XiamiSongSummary extends SongSummary {
        @JSONField(name = "file")
        private String url;

        @Bindable
        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
            notifyPropertyChanged(BR.url);
        }

        @Override
        public String toString() {
            return super.toString().concat("\n").concat("XiamiSongSummary{" +
                    "url='" + url + '\'' +
                    '}');
        }
    }

    public static class XiamiSource extends Source {
        @JSONField(name = "songList")
        private ObservableArrayList<XiamiSongSummary> list;

        @Bindable
        public ObservableArrayList<XiamiSongSummary> getList() {
            return list;
        }

        public void setList(ObservableArrayList<XiamiSongSummary> list) {
            this.list = list;
            notifyPropertyChanged(BR.list);
        }

        @Override
        public String toString() {
            return super.toString().concat("\n").concat("XiamiSource{" +
                    "list=" + list +
                    '}');
        }
    }

    public static class OtherSource extends Source {
        @JSONField(name = "songList")
        private ObservableArrayList<SongSummary> list;

        @Bindable
        public ObservableArrayList<SongSummary> getList() {
            return list;
        }

        public void setList(ObservableArrayList<SongSummary> list) {
            this.list = list;
            notifyPropertyChanged(BR.list);
        }

        @Override
        public String toString() {
            return super.toString().concat("\n").concat("OtherSource{" +
                    "list=" + list +
                    '}');
        }
    }

    public static class Source extends IData {
        @JSONField(name = "success")
        private boolean isSuccess;
        @JSONField(name = "total")
        private int total;

        @Bindable
        public boolean isSuccess() {
            return isSuccess;
        }

        public void setSuccess(boolean success) {
            isSuccess = success;
            notifyPropertyChanged(BR.success);
        }

        @Bindable
        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
            notifyPropertyChanged(BR.total);
        }

        @Override
        public String toString() {
            return "Source{" +
                    "isSuccess=" + isSuccess +
                    ", total=" + total +
                    '}';
        }
    }

    public static class Album extends IData {
        @JSONField(name = "id")
        private String id;
        @JSONField(name = "name")
        private String name;
        @JSONField(name = "cover")
        private String cover;
        @JSONField(name = "coverBig")
        private String coverBig;
        @JSONField(name = "coverSmall")
        private String coverSmall;

        @Bindable
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
            notifyPropertyChanged(BR.id);
        }

        @Bindable
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
            notifyPropertyChanged(BR.name);
        }

        @Bindable
        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
            notifyPropertyChanged(BR.cover);
        }

        @Bindable
        public String getCoverBig() {
            return coverBig;
        }

        public void setCoverBig(String coverBig) {
            this.coverBig = coverBig;
            notifyPropertyChanged(BR.coverBig);
        }

        @Bindable
        public String getCoverSmall() {
            return coverSmall;
        }

        public void setCoverSmall(String coverSmall) {
            this.coverSmall = coverSmall;
            notifyPropertyChanged(BR.coverSmall);
        }

        @Override
        public String toString() {
            return "Album{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", cover='" + cover + '\'' +
                    ", coverBig='" + coverBig + '\'' +
                    ", coverSmall='" + coverSmall + '\'' +
                    '}';
        }
    }

    public static class Artist extends IData {
        @JSONField(name = "id")
        private String id;
        @JSONField(name = "name")
        private String name;
        @JSONField(name = "avatar")
        private String avatar;

        @Bindable
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
            notifyPropertyChanged(BR.id);
        }

        @Bindable
        public String getName() {
            return name;

        }

        public void setName(String name) {
            this.name = name;
            notifyPropertyChanged(BR.name);
        }

        @Bindable
        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
            notifyPropertyChanged(BR.avatar);
        }

        @Override
        public String toString() {
            return "Artist{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", avatar='" + avatar + '\'' +
                    '}';
        }
    }

    public static class SongSummary extends IData {
        @JSONField(name = "album")
        private Album album;
        @JSONField(name = "artists")
        private ObservableArrayList<Artist> artists;
        @JSONField(name = "name")
        private String name;
        @JSONField(name = "id")
        private String id;
        @JSONField(name = "needPay")
        private boolean needPay;

        @Bindable
        public Album getAlbum() {
            return album;
        }

        public void setAlbum(Album album) {
            this.album = album;
            notifyPropertyChanged(BR.album);
        }

        @Bindable
        public ObservableArrayList<Artist> getArtists() {
            return artists;
        }

        public void setArtists(ObservableArrayList<Artist> artists) {
            this.artists = artists;
            notifyPropertyChanged(BR.artists);
        }

        @Bindable
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
            notifyPropertyChanged(BR.name);
        }

        @Bindable
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
            notifyPropertyChanged(BR.id);
        }

        @Bindable
        public boolean isNeedPay() {
            return needPay;
        }

        public void setNeedPay(boolean needPay) {
            this.needPay = needPay;
            notifyPropertyChanged(BR.needPay);
        }

        @Override
        public String toString() {
            return "SongSummary{" +
                    "album=" + album +
                    ", artists=" + artists +
                    ", name='" + name + '\'' +
                    ", id='" + id + '\'' +
                    ", needPay=" + needPay +
                    '}';
        }
    }
}
