package com.wsgc.PIMbackend.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/array")
public class ArrayController {

    @GetMapping("/add-heading")
    public ResponseEntity<String[]> addHeadingToArray() {
        String[] originalArray = {"Item 1", "Item 2", "Item 3"};
        String heading = "This is the heading";

        String[] modifiedArray = new String[originalArray.length + 1];
        modifiedArray[0] = heading;
        System.arraycopy(originalArray, 0, modifiedArray, 1, originalArray.length);

        return ResponseEntity.ok(modifiedArray);
    }
}
