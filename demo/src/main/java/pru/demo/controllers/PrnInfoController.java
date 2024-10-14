package pru.demo.controllers;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pru.demo.dtos.PrnInfoDto;
import pru.demo.entities.PrnRandomInfo;
import pru.demo.repos.PrnInfoRepo;

@RestController
@RequestMapping("fu/prn")
public class PrnInfoController {

    @Autowired
    private PrnInfoRepo repo;

    @Autowired
    private ModelMapper modelMapper;

    private static final List<String> DESCRIPTION_LIST = Arrays.asList(
            "Design and construct a traditional Japanese Koi pond with waterfall feature",
            "Install custom filtration and aeration systems to maintain water quality for Koi pond",
            "Create a landscaped garden surrounding the Koi pond with seating areas",
            "Build a large Koi pond with integrated lighting and underwater viewing window",
            "Construct a natural-looking Koi pond with varied depths and aquatic plants");

    private static final List<String> PHONE_LIST = Arrays.asList(
            "05551234567",
            "05557654321",
            "05559876543",
            "05553210987",
            "05556781234");

    private static final List<String> NAME_LIST = Arrays.asList(
            "Sophia", "Liam", "Emma", "Noah", "Olivia");

    private static final List<String> LAST_NAME_LIST = Arrays.asList(
            "Nguyen", "Tran", "Pham", "Le", "Vo");

    private static final List<String> ADDRESS_LIST = Arrays.asList(
            "123 Main St", "456 Maple Ave", "789 Oak Blvd", "101 Pine Cir", "202 Birch Dr");

    private static final List<Date> DATE_OF_BIRTH_LIST = Arrays.asList(
            Date.valueOf("1990-01-01"), Date.valueOf("1991-02-02"), Date.valueOf("1992-03-03"), Date.valueOf("1993-04-04"), Date.valueOf("1994-05-05"));

    private static final List<String> EMAIL_LIST = Arrays.asList(
            "sophia@gmail.com", "liam@gmail.com", "emma@gmail.com", "noah@gmail.com", "olivia@gmail.com");

    @GetMapping("create")
    public ResponseEntity<?> createRandomRequest() {
        try {
            Random random = new Random();
            PrnRandomInfo randomInfo = new PrnRandomInfo(
                    DESCRIPTION_LIST.get(random.nextInt(DESCRIPTION_LIST.size())),
                    NAME_LIST.get(random.nextInt(NAME_LIST.size())),
                    LAST_NAME_LIST.get(random.nextInt(LAST_NAME_LIST.size())),
                    PHONE_LIST.get(random.nextInt(PHONE_LIST.size())),
                    ADDRESS_LIST.get(random.nextInt(ADDRESS_LIST.size())),
                    DATE_OF_BIRTH_LIST.get(random.nextInt(DATE_OF_BIRTH_LIST.size())),
                    EMAIL_LIST.get(random.nextInt(EMAIL_LIST.size()))
            );

            repo.save(randomInfo);
        } catch (Exception e) {
            // Log the exception
        }
        return ResponseEntity.ok("Anyway oke!");
    }

    @GetMapping("scan")
    public ResponseEntity<List<PrnInfoDto>> scanRequests() {
        List<PrnInfoDto> dtos = null;
        try {
            List<PrnRandomInfo> queriedRes = repo.findNotScanned();
            queriedRes.forEach(item -> item.setScanned(true));
            repo.saveAll(queriedRes);

            dtos = queriedRes.stream()
                    .map(item -> modelMapper.map(item, PrnInfoDto.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            // Log the exception
        }
        return ResponseEntity.ok(dtos);
    }
}
