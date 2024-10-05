package pru.demo;

import java.util.List;
import org.antlr.v4.runtime.misc.NotNull;
import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import pru.demo.dtos.LoginRequest;
import pru.demo.dtos.QuestionDto;
import pru.demo.entities.PlayerAccount;
import pru.demo.repos.PlayerAccountRepo;
import pru.demo.repos.QuestionRepo;

@Service
public class SimpleGameService {
    @Autowired
    private PlayerAccountRepo playerAccountRepo;
    @Autowired
    private QuestionRepo questionRepo;
    @Autowired
    private ModelMapper modelMapper;

    public boolean checkLogin(@NotNull LoginRequest request) {
        List<PlayerAccount> playerAccounts = playerAccountRepo.findAll();
        return playerAccounts.stream()
            .anyMatch(a -> a.getUsername().equals(request.getUsername()) && a.getPassword().equals(request.getPassword()));
    }

    public List<QuestionDto> getAllQuestions() {
        return questionRepo.findAll().stream()
            .map(e -> modelMapper.map(e, QuestionDto.class))
            .toList();
    }
}
