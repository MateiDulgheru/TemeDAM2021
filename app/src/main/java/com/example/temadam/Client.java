package com.example.temadam;

import android.os.Parcel;
import android.os.Parcelable;

public class Client implements Parcelable{

    private String username;
    private String password;
    private String emailAdress;

    public Client() {
    }

    public Client(String username, String password, String emailAdress) {
        this.username = username;
        this.password = password;
        this.emailAdress = emailAdress;
    }

    protected Client(Parcel in) {
        username = in.readString();
        password = in.readString();
        emailAdress = in.readString();
    }

    public static final Parcelable.Creator<Client> CREATOR = new Parcelable.Creator<Client>() {
        @Override
        public Client createFromParcel(Parcel in) {
            return new Client(in);
        }

        @Override
        public Client[] newArray(int size) {
            return new Client[size];
        }
    };

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", emailAdress='").append(emailAdress).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(password);
        dest.writeString(emailAdress);
    }
}
