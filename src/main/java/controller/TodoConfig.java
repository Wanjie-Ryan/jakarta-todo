/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author VICTUS
 */
@ApplicationPath("api/v1") // this will be the entry point to our API, it extends application from the javax rs
public class TodoConfig extends Application {
    
}
