package pru.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
import pru.demo.entities.PlayerAccount;
import pru.demo.entities.Question;
import pru.demo.repos.PlayerAccountRepo;
import pru.demo.repos.QuestionRepo;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	private PlayerAccountRepo playerAccountRepo;
	@Autowired
	private QuestionRepo questionRepo;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostConstruct
	public void init() {

		if (playerAccountRepo.findAll().isEmpty()) {
			// Insert 2 player accounts
			PlayerAccount account1 = new PlayerAccount("user1", "pass1");
			PlayerAccount account2 = new PlayerAccount("user2", "pass2");
			playerAccountRepo.save(account1);
			playerAccountRepo.save(account2);

		}
		if (questionRepo.findAll().isEmpty()) {
			// Insert 20 questions
			String[] questions = {
					"What is the capital of Japan?\nA. Seoul B. Tokyo C. Beijing D. Bangkok",
					"Who wrote \"Hamlet\"?\nA. Charles Dickens B. Mark Twain C. William Shakespeare D. George Orwell",
					"What is the largest planet in our solar system?\nA. Earth B. Mars C. Jupiter D. Saturn",
					"What is the boiling point of water?\nA. 90°C B. 100°C C. 110°C D. 120°C",
					"Who painted the Mona Lisa?\nA. Vincent Van Gogh B. Pablo Picasso C. Leonardo da Vinci D. Claude Monet",
					"What is the smallest prime number?\nA. 1 B. 2 C. 3 D. 5",
					"What is the chemical symbol for gold?\nA. Ag B. Au C. Pt D. Pb",
					"Who discovered penicillin?\nA. Alexander Fleming B. Marie Curie C. Isaac Newton D. Albert Einstein",
					"What is the capital of Australia?\nA. Sydney B. Melbourne C. Canberra D. Perth",
					"What is the main ingredient in guacamole?\nA. Tomatoes B. Avocados C. Onions D. Peppers",
					"Who invented the telephone?\nA. Nikola Tesla B. Alexander Graham Bell C. Thomas Edison D. Henry Ford",
					"How many continents are there on Earth?\nA. 5 B. 6 C. 7 D. 8",
					"What is the hardest natural substance on Earth?\nA. Iron B. Diamond C. Gold D. Silver",
					"What is the largest mammal in the world?\nA. Elephant B. Blue Whale C. Giraffe D. Hippopotamus",
					"Which planet is known as the Red Planet?\nA. Venus B. Mars C. Mercury D. Neptune",
					"What is the most widely spoken language in the world?\nA. English B. Spanish C. Chinese D. Hindi",
					"Who is the author of \"Pride and Prejudice\"?\nA. Emily Brontë B. Jane Austen C. Charlotte Brontë D. Louisa May Alcott",
					"What is the powerhouse of the cell?\nA. Nucleus B. Ribosome C. Mitochondria D. Endoplasmic Reticulum",
					"What is the capital of Canada?\nA. Vancouver B. Toronto C. Ottawa D. Montreal",
					"Who is known as the \"Father of Computers\"?\nA. Steve Jobs B. Bill Gates C. Charles Babbage D. Alan Turing"
			};

			char[] answers = { 'B', 'C', 'C', 'B', 'C', 'B', 'B', 'A', 'C', 'B', 'B', 'C', 'B', 'B', 'B', 'C', 'B', 'C',
					'C', 'C' };

			for (int i = 0; i < questions.length; i++) {
				Question question = new Question(questions[i], answers[i]);
				questionRepo.save(question);
			}
		}
	}
}
