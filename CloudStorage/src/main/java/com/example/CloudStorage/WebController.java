package com.example.CloudStorage;

import java.io.IOException;
import java.nio.charset.Charset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

  @Value("gs://my_home_bucket_2887/pom.xml")
  private Resource gcsFile;

  @GetMapping("/")
  public String readGcsFile() throws IOException {
    return StreamUtils.copyToString(
        gcsFile.getInputStream(),
        Charset.defaultCharset());
  }
}
