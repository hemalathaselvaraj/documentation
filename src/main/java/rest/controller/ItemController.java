package rest.controller;

import io.swagger.annotations.*;
import model.Item;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.schema.Model;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by rajesh on 27-Feb-16.
 */

@EnableSwagger2
@Controller
@RequestMapping("/item")
@Api(value="item", description="Everything about an item record", position = 1)
public class ItemController {

    @RequestMapping(method = RequestMethod.POST, value = "/updateTrackingStatus", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update item metadata information such as status etc.",
            notes = "This service lets middleware know the status of an item record i.e if in transit etc..", nickname = "updateTrackingStatus", position = 0)
    @ResponseBody
    @ApiResponses(value = {@ApiResponse(code = 405, message = "Invalid input") })
    public String updateTrackingStatus(@ApiParam(value = "Item's metadata information.", required = true, name = "item") @RequestBody Item item) {
        return "updateTrackingStatus Invoked. Request Body : " + item;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/refile", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Refile item",
            notes = "This service enables the refile workflow which essentially updates the item status to available in the middleware.", nickname = "refile", position = 1)
    @ResponseBody
    @ApiResponses(value = {@ApiResponse(code = 405, message = "Invalid input") })
    public String refile(@ApiParam(value = "Item information for refile.", required = true, name = "item") @RequestBody Item item) {
        return "refile Invoked. Request Body : " + item;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/request", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Request item",
            notes = "This service is used to request an item for either checking out, recall or hold scenarios.", nickname = "request", position = 2)
    @ResponseBody
    @ApiResponses(value = {@ApiResponse(code = 405, message = "Invalid input") })
    public String request(@ApiParam(value = "Item being requested.", required = true, name = "item") @RequestBody Item item) {
        return "refile Invoked. Request Body : " + item;
    }

}
