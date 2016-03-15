package rest.controller;

import io.swagger.annotations.*;
import model.Content;
import model.Loan;
import model.Request;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by rajeshbabuk on 3/4/16.
 */

@EnableSwagger2
@Controller
@RequestMapping("/sharedCollection")
@Api(value="shared-collection", description="Everything about your shared collection in the middleware.", position = 3)
public class SharedCollectionController {

    @RequestMapping(method = RequestMethod.GET, value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "This service generates either a full or incremental export of the shared collection information",
            notes = "Generate shared collection information and transmit to requesting institution's FTP location. " +
                    "This would typically be updates to shared collection information of partner sites that the requesting institution is interested in.", nickname = "generateDump")
    @ResponseBody
    @ApiResponses(value = {@ApiResponse(code = 405, message = "Invalid input")})
    public String generateDump(@ApiParam(value = "Ids of institutions whose shared collection updates are requested." +
            "Use PR for Princeton, CL for Columbia, NY for NYPL.", defaultValue = "PR",
                               allowableValues = "PR,CL,NY", allowMultiple = true) @RequestParam String[] institutionIds,
                               @ApiParam(value = "Type of export - Full (use 0) or Incremental (use 1)", required = true, name = "fetchType") @RequestParam int fetchType,
                               @ApiParam(value = "Get updates to middleware collection since the date provided. Default will be  updates since the previous day. Date format will be a string (mm-dd-yyyy)", name = "date") @RequestParam String date) {
        return "generateDump Invoked. Institution Ids : " + institutionIds + " Fetch Type : " + fetchType + " Date : " + date;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retrieves Bib/Holdings/Item information",
            notes = "This service fetches results based on search parameters. You can specify the types of record(s) that needs to be included in the response - " +
                    "for example Bibliographic, Holdings, Items. The response is a marcxml record with Bibliographic, Holdings and Item information.", nickname = "generateDump")
    @ResponseBody
    @ApiResponses(value = {@ApiResponse(code = 405, message = "Invalid input")})
    public String search(@ApiParam(value = "Document type for which search field values are provided for (Ex. Bibliographic, Holdings, Item)", required = true, name = "searchDocType") @RequestParam String searchDocType,
                         @ApiParam(value = "Available fields for Bib: Author, Title, ISBN, ISSN, OCLC; Item: Barcode, Status (Acceptable values - Available, Not Available)", required = true, name = "fieldName") @RequestParam String fieldName,
                         @ApiParam(value = "Search field value", required = true, name = "fieldValue") @RequestParam String fieldValue,
                         @ApiParam(value = "Specify type of documents in the response. Use (0 for Bib only, 1 for Items and 2 for Bib/Holdings/Items). Default is 2.", name = "responseDocTypes") @RequestParam int responseDocTypes,
                         @ApiParam(value = "Filter out results by ids. Use PR for Princeton, CL for Columbia, NY for NYPL.", required = true, defaultValue = "PR", allowableValues = "PR,CL,NY", allowMultiple = true, name = "institutionIds") @RequestParam String[] institutionIds,
                         @ApiParam(value = "Indicate if you would like to filter on Shared, Open or Private records.", name = "collectionGroupDesignation") @RequestParam String collectionGroupDesignation) {
        return "search Invoked. Search Doc Type: " + searchDocType + " Field Name : " + fieldName + " Field Value : " + fieldValue + " Response Doc Types : " + responseDocTypes + " Institution Ids : " + institutionIds + " Collection Group Designation : " + collectionGroupDesignation;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update shared collection",
            notes = "This service allows updates to bibliographic, holdings and item information in the middleware", nickname = "update")
    @ResponseBody
    @ApiResponses(value = {@ApiResponse(code = 405, message = "Invalid input") })
    public String update(@ApiParam(value = "Content to be updated", required = true, name = "content") @RequestBody Content content) {
        return "update Invoked. Request Body : " + content;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/accession", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Add new item record to the middleware",
            notes = "This service can be invoked by the IMS (Inventory Management System) client in order to notify the middleware of newly added items.", nickname = "accession")
    @ResponseBody
    @ApiResponses(value = {@ApiResponse(code = 405, message = "Invalid input") })
    public String accession(@ApiParam(value = "Item being accessioned.", required = true, name = "loan") @RequestBody Loan loan) {
        return "accession Invoked. Request Body : ";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deaccession", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Remove item record from the middleware",
            notes = "This service can be invoked by the IMS (Inventory Management System) client in order to notify the middleware of removed items.", nickname = "deaccession")
    @ResponseBody
    @ApiResponses(value = {@ApiResponse(code = 405, message = "Invalid input") })
    public String deaccession(@ApiParam(value = "Item being deaccessioned.", required = true, name = "loan") @RequestBody Loan loan) {
        return "deaccession Invoked. Request Body : " + loan;
    }


}
