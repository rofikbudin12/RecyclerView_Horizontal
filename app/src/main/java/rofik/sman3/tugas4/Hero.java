package rofik.sman3.tugas4;

import android.os.Parcel;
import android.os.Parcelable;

public class Hero implements Parcelable {

    Integer picture;
    String name;

    public String getDes() {
        return des;
    }

    String des;

    public Hero(Integer picture, String name, String des) {
        this.picture = picture;
        this.name = name;
        this.des = des;
    }

    public Integer getPicture() {
        return picture;
    }

    public String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.picture);
        dest.writeString(this.name);
        dest.writeString(this.des);
    }

    protected Hero(Parcel in) {
        this.picture = (Integer) in.readValue(Integer.class.getClassLoader());
        this.name = in.readString();
        this.des = in.readString();
    }

    public static final Creator<Hero> CREATOR = new Creator<Hero>() {
        @Override
        public Hero createFromParcel(Parcel source) {
            return new Hero(source);
        }

        @Override
        public Hero[] newArray(int size) {
            return new Hero[size];
        }
    };
}
