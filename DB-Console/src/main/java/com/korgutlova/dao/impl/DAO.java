package com.korgutlova.dao.impl;

import com.korgutlova.configuration.ConnectionDB;

import java.sql.Connection;

abstract class DAO {
   Connection connection = ConnectionDB.getConnection();
}
