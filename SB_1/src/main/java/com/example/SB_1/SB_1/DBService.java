package com.example.SB_1.SB_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {
//    Autowired is field injection
//    @Autowired
//    private DB db;

//    Constructor injection - with constructor injection u can make "db" immutable by using "final" keyWord
    final private DB db;
    DBService(DB db) {
        this.db = db;
    }

    String getData() {
        return db.getData();
    }
}
