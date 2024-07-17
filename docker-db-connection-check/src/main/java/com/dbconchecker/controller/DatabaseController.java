package com.dbconchecker.controller;
import com.dbconchecker.services.DatabaseConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.dbconchecker.Beans.DataBaseConfig;

@RestController
@RequestMapping("/api/database")
public class DatabaseController {

    @Autowired
    private DatabaseConnectionService databaseConnectionService;

    @PostMapping("/check")
    public String checkDatabaseConnection(@RequestBody DataBaseConfig config) {
        boolean isConnected = databaseConnectionService.checkConnection(config);
        return isConnected ? "Connected successfully!" : "Failed to connect.";
    }

}
