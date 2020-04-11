package com.example.sql_example.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sql_example.utils.DatabaseHelper;

import static com.example.sql_example.repository.SQLScripts.*;

public class UsersProvider extends ContentProvider {

    private static final String PROVIDER_NAME = "com.example.sql_example";
    private static final String URI = "content://" + PROVIDER_NAME + "/";

    private static final int USERS = 1;
    private static final int USERS_ID = 2;

    private static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(PROVIDER_NAME, "users", USERS);
        uriMatcher.addURI(PROVIDER_NAME, "users/#", USERS_ID);
    }

    DatabaseHelper databaseHelper;

    @Override
    public boolean onCreate() {
        databaseHelper = new DatabaseHelper(getContext(), "UserDb", null, 1);
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        Cursor cursor;

        switch (uriMatcher.match(uri)) {
            case USERS:
                cursor = db.rawQuery(getAllUsersScript(100), null);
                break;
            case USERS_ID:
                int id = Integer.parseInt(uri.getLastPathSegment());
                cursor = db.rawQuery(getUserById(id), null);
                break;
            default:
                throw new IllegalArgumentException("Неверный uri: " + uri);
        }

        cursor.setNotificationUri(getContext().getContentResolver(), Uri.parse((URI + "users")));

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
