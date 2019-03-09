package com.coderiver.codeforum.contract.controller;

import com.coderiver.codeforum.common.entity.Result;
import com.coderiver.codeforum.common.entity.StatusCode;
import com.coderiver.codeforum.contract.pojo.UserContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by Shiyu Rao on 09/03/2019.
 */
@RestController
@Api(tags = "User Module", value = "/user", description = "User Management Service",
        produces = "application/json")
@RequestMapping("/user") // here is the web gateway mapping
public class UserController {

    @ApiOperation(value="get all users",response=Result.class)
    @ApiResponses(value={
            @ApiResponse(code=200,message="User Context List",response=Result.class),
            @ApiResponse(code=500,message="Internal Server Error"),
    })
    @RequestMapping(value = "/user", method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<Result> findAll(){
        // moc response

        return new ResponseEntity<>(new Result(true, StatusCode.OK, "find All Success", new ArrayList<UserContext>()), HttpStatus.OK);
    }
}
