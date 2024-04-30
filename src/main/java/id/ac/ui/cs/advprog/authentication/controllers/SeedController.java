package id.ac.ui.cs.advprog.authentication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import id.ac.ui.cs.advprog.authentication.services.SeedService;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/seed")
public class SeedController {
  @Autowired
  private SeedService seedService;

  @GetMapping("/auth")
  public ResponseEntity<String> seedMaster() {
    boolean isSeeded = seedService.seedAuth();
    if (!isSeeded) {
      return ResponseEntity.badRequest().body("Seeding data auth failed.");
    }
    return ResponseEntity.ok("Seeding data auth completed successfully.");
  }
}
