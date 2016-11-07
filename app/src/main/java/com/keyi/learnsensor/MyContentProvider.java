package com.keyi.learnsensor;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2016/11/1.
 */
public class MyContentProvider extends ContentProvider{

    @Override
    public boolean onCreate() {//在创建ContentProvider时调用
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {//用于查询指定Uri的ContentProvider，返回一个Cursor
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {//用于返回指定的Uri中的数据的MIME类型
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {//用于添加数据到指定Uri的ContentProvider中
        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {//用于从指定Uri的ContentProvider中删除数据
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {//用于更新指定Uri的ContentProvider中的数据
        return 0;
    }
}
