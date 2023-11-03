package de.hbrs.ia.erasmux.Controller;


import de.hbrs.ia.erasmux.Entity.SalesMan;
import de.hbrs.ia.erasmux.Repository.SalesmanRepository;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class SalesmenController {

    //@Autowired
    @Autowired
    private SalesmanRepository salesmanRepository;

    /**
     * POST-Method for creating a salesman
     * @param salesMan JSON-object of a salesman
     * @return HTTP-Response including response string
     */
    @PostMapping("/create/")
    public String createSalesman(@RequestBody SalesMan salesMan) {
//    public String createSalesman(@RequestBody SalesMan salesMan) {
        if (salesMan.getSid() == null) {
            return "salesman is null";
        }
        if (salesMan.getEmail() == null) {
            return "salesman is null";
        }
        if (salesMan.getFirstName() == null) {
            return "salesman is null";
        }
        if (salesMan.getLastName() == null) {
            return "salesman is null";
        }
        salesmanRepository.save(salesMan);
        return "created: " + salesMan;
    }

    @GetMapping("/getAll")
    public String readSalesman() {
//        return "sth";
        return salesmanRepository.findAll().toString();
    }

    @GetMapping("/find")
    public String findSalesman(int sid) {
        return salesmanRepository.findBySid(sid).toString();
    }


    @GetMapping("/deleteAll")
    public String deleteAll() {
        salesmanRepository.deleteAll();
        return "deleted db";
    }
}

//package de.hbrs.ia.erasmux.Controller;
//
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import de.hbrs.ia.erasmux.Entity.SalesMan;
//
///**
// * RestController for CRUD operations for salesmen
// */
//@RestController
//public class SalesmenController {
//
//    private final ManagePersonal managePersonal = new ManagePersonalImpl();
//
//    /**
//     * POST-Method for creating a salesman
//     * @param salesman JSON-object of a salesman
//     * @return HTTP-Response including response string
//     */
//    @PostMapping("api/salesmen/create")
//    public ResponseEntity<String> createSalesman(@RequestBody SalesMan salesman){
//        managePersonal.createSalesMan(salesman);
//        return ResponseEntity.ok("Salesman created");
//    }
//
//    /**
//     * GET-Method for reading a salesman
//     * @param sid id of requested salesman
//     * @return JSON-object of requested salesman
//     */
//    @GetMapping("api/salesmen/read/{sid}")
//    public ResponseEntity<SalesMan> readSalesman(@PathVariable int sid){
//        SalesMan salesMan = managePersonal.readSalesMan(sid);
//        return salesMan != null ? ResponseEntity.ok(salesMan) : ResponseEntity.notFound().build();
//    }
//
//    /**
//     * PUT-Method for updating an existing salesman
//     * @param sid id of salesman that should be updated
//     * @param updatedSalesman JSON-Object that represents updated salesman
//     * @return HTTP-Response including response string
//     */
//    @PutMapping("api/salesmen/update/{sid}")
//    public ResponseEntity<String> updateSalesman(@PathVariable int sid, @RequestBody SalesMan updatedSalesman){
//        managePersonal.updateSalesMan(sid, updatedSalesman);
//        // Todo updatedSalesman needs to have some exception handling to provide appropriate response in api
//        return ResponseEntity.ok("Salesman updated");
//    }
//
//    /**
//     * DELETE-Method for deleting a salesman
//     * @param sid id of salesman that should be deleted
//     * @return HTTP-Response including response string
//     */
//    @DeleteMapping("api/salesmen/delete/{sid}")
//    public ResponseEntity<String> deleteSalesman(@PathVariable int sid){
//        managePersonal.deleteSalesMan(sid);
//        // Todo deleteSalesman needs to have some exception handling to provide appropriate response in api
//        return ResponseEntity.ok("Salesman deleted");
//    }
//}
