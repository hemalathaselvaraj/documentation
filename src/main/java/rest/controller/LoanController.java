package rest.controller;

import io.swagger.annotations.*;
import model.Item;
import model.Loan;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by rajeshbabuk on 3/4/16.
 */

@EnableSwagger2
@Controller
@RequestMapping("/loan")
@Api(value="loan", description="Loan record", position = 2)
public class LoanController {

    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create a loan record in the middleware",
            notes = "This service lets middleware know the item has been picked up by the patron and is out on loan with a due date", nickname = "create")
    @ResponseBody
    @ApiResponses(value = {@ApiResponse(code = 405, message = "Invalid input") })
    public String create(@ApiParam(value = "Loan information.", required = true, name = "loan") @RequestBody Loan loan) {
        return "create Invoked. Request Body : " + loan;
    }
}
