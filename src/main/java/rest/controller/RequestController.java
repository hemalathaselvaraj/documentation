package rest.controller;

import io.swagger.annotations.*;
import model.Loan;
import model.Request;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by rajeshbabuk on 3/4/16.
 */

@EnableSwagger2
@Controller
@RequestMapping("/request")
@Api(value="request", description="Requests", position = 4)
public class RequestController {

    @RequestMapping(method = RequestMethod.GET, value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Search for requests",
            notes = "Enables searching of requests in the middleware.", nickname = "create", response = Request.class)
    @ResponseBody
    @ApiResponses(value = {@ApiResponse(code = 405, message = "Invalid input") })
    public String search(@ApiParam(value = "Item Barcode", required = true, name = "itemBarcode") @RequestParam String itemBarcode,
                          @ApiParam(value = "Barcode of the patron", required = true, name = "patronBarcode") @RequestParam String patronBarcode) {
        return "request Invoked. Item Barcode : " + itemBarcode + " Patron Barcode : " + patronBarcode;
    }
}
