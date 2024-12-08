package org.gklsan.springboot.myjavalearning.rest;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.io.*;
import java.util.concurrent.Executors;

@RestController
public class StreamController {
  @GetMapping("/api/stream")
  public ResponseBodyEmitter streamData() {
    ResponseBodyEmitter emitter = new ResponseBodyEmitter();

    Executors.newSingleThreadExecutor().execute(() -> {
      try {
        for (int i = 0; i < 25; i++) {
          emitter.send("Chunk " + i + "\n");
          Thread.sleep(1000); // Simulate delay
        }
        emitter.complete();
      } catch (Exception e) {
        emitter.completeWithError(e);
      }
    });

    return emitter;
  }


  // Please try following to generate the file through command line
  // yes "Sample data for spring boot file streaming" | head -n 50000000 > large-file.txt
  @GetMapping("/api/download")
  public void downloadFile(HttpServletResponse response) throws IOException {
    File file = new File("large-file.txt");
    response.setContentType("application/octet-stream");
    response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());

    long startTime = System.currentTimeMillis();
    System.out.println("Start Time: " + startTime);

    try (InputStream inputStream = new FileInputStream(file);
         OutputStream outputStream = response.getOutputStream()) {
      byte[] buffer = new byte[1024];
      int bytesRead;
      while ((bytesRead = inputStream.read(buffer)) != -1) {
//        System.out.println(".");
        outputStream.write(buffer, 0, bytesRead);
      }
    }
    System.out.println("End Time: " + System.currentTimeMillis());

    long endTime = System.currentTimeMillis();
    System.out.println("End Time: " + endTime);
    System.out.println("Total Time Taken: " + (endTime - startTime) + " ms");
  }

  @GetMapping("/api/downloadold")
  public void downloadFileOld(HttpServletResponse response) throws IOException {
    // Path to the file
    File file = new File("large-file.txt");

    // Set response headers
    response.setContentType("application/octet-stream");
    response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());

    // Record start time
    long startTime = System.currentTimeMillis();
    System.out.println("Start Time: " + startTime);

    // Read file into memory
    byte[] fileContent = java.nio.file.Files.readAllBytes(file.toPath());

    // Write the file content to the response output stream
    response.getOutputStream().write(fileContent);

    // Record end time
    long endTime = System.currentTimeMillis();
    System.out.println("End Time: " + endTime);
    System.out.println("Total Time Taken: " + (endTime - startTime) + " ms");
  }

}
