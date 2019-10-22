package com.imooc.sm.dao;

import com.imooc.sm.entity.Staff;

public interface SelfDao {
    Staff selectByAccount(String account);
}
