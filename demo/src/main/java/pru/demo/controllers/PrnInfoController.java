package pru.demo.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
            "Sophia Nguyen",
            "Liam Tran",
            "Emma Pham",
            "Noah Le",
            "Olivia Vo");

    @GetMapping("create")
    public ResponseEntity<?> createRandomRequest() {
        try {
            Random random = new Random();
            List<PrnRandomInfo> randomInfos = random.ints(0, DESCRIPTION_LIST.size())
                    .distinct()
                    .limit(1)
                    .mapToObj(i -> new PrnRandomInfo(
                            DESCRIPTION_LIST.get(i),
                            NAME_LIST.get(random.nextInt(NAME_LIST.size())),
                            PHONE_LIST.get(random.nextInt(PHONE_LIST.size()))))
                    .collect(Collectors.toList());

            repo.saveAll(randomInfos);

        } catch (Exception e) {
            // Exception handling logic, e.g., log the exception

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
            // Exception handling logic, e.g., log the exception
        }
        return ResponseEntity.ok(dtos);
    }
}
