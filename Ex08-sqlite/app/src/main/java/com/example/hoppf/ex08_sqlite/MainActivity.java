package com.example.hoppf.ex08_sqlite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    interface ICursor {
        boolean moveToFirst();
        int getColumnIndex(String columnName);
        String getString(int columnIndex);
        short getShort(int columnIndex);
        int getInt(int columnIndex);
        long getLong(int columnIndex);
        void close();
    }

    class Cursor2 implements ICursor {
        private final Cursor cursor;

        public Cursor2(Cursor cursor) {
            this.cursor = cursor;
        }

        @Override
        public boolean moveToFirst() {
            return cursor.moveToFirst();
        }

        @Override
        public int getColumnIndex(String columnName) {
            return cursor.getColumnIndex(columnName);
        }

        @Override
        public String getString(int columnIndex) {
            return cursor.getString(columnIndex);
        }

        @Override
        public short getShort(int columnIndex) {
            return cursor.getShort(columnIndex);
        }

        @Override
        public int getInt(int columnIndex) {
            return cursor.getInt(columnIndex);
        }

        @Override
        public long getLong(int columnIndex) {
            return cursor.getLong(columnIndex);
        }

        @Override
        public void close() {
            cursor.close();
        }
    }

    interface ISqliteRepository {
        void execSQL(String query);
        ICursor rawQuery(String query);
    }

    class SqliteRepository implements ISqliteRepository {
        private final SQLiteDatabase db;

        public SqliteRepository(SQLiteDatabase db) {
            this.db = db;
        }

        public void execSQL(String query) {
            db.execSQL(query);
        }

        public ICursor rawQuery(String query) {
            return new Cursor2(db.rawQuery(query, null));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txv_username = (TextView) findViewById(R.id.txv_username);
        TextView txv_password = (TextView) findViewById(R.id.txv_password);

        SqliteRepository sqliteRepository = new SqliteRepository(openOrCreateDatabase("mydb", MODE_PRIVATE, null));

        sqliteRepository.execSQL(MyModel.SQL_CREATETABLE);

        sqliteRepository.execSQL("INSERT INTO MyModel VALUES ('lolcz', 13);");

        ICursor c = sqliteRepository.rawQuery("SELECT * FROM MyModel");

        if (c.moveToFirst()) {
            String s = c.getString(c.getColumnIndex("s"));
            long x = c.getLong(c.getColumnIndex("x"));
            txv_username.setText(s);
            txv_password.setText(Long.toString(x));
        } else {
            txv_username.setText("poop");
            txv_password.setText("shit");
        }
        c.close();
    }
}
