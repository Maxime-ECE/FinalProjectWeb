import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { QuizzService } from "../services/quizz.service"

@Component({
  selector: 'epf-quizz-en-cours',
  templateUrl: './quizz-en-cours.component.html',
  styleUrls: ['./quizz-en-cours.component.scss']
})
export class QuizzEnCours implements OnInit {
  quizz: any = {};
  currentQuestion: any;
  selectedOption: string = '';
  correctAnswer: string = '';
  showAnswer: boolean = false;
  currentQuizId: any;
  currentQuestionIndex: number = 0;
  name : string = '';
  questions: any[] = [];

  constructor(private route: ActivatedRoute, private quizzService: QuizzService) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.currentQuizId = Number(params.get('id')) || 0; // Convertit l'ID en number
      this.quizzService.getQuizTitleQuestionsAndAnswersWithId().subscribe(data => {
        this.quizz = data;
        console.log(this.quizz);

        if (this.quizz && this.quizz.length > 0) {
          // Utilise === pour comparer les types également
          const currentQuiz = this.quizz.find((quiz: any) => quiz.id === this.currentQuizId);
          console.log(currentQuiz);
          if (currentQuiz) {
            this.name = currentQuiz.titre;
            // Maintenant, nous devons filtrer les questions pertinentes pour ce quiz
            this.questions = this.quizz.filter((quiz: any) => quiz.id === this.currentQuizId);
            // Initialisez l'index de la question à zéro pour afficher la première question
            this.currentQuestionIndex = 0;
            this.updateCurrentQuestion(); // Met à jour la question actuelle à afficher
          } else {
            console.log("Le quiz n'a pas été trouvé.");
          }
        }
      });
    });
  }

  // Ajoutez cette méthode pour mettre à jour la question actuelle à afficher
  updateCurrentQuestion() {
    if (this.questions && this.questions.length > 0) {
      this.currentQuestion = this.questions[this.currentQuestionIndex];
      this.correctAnswer = this.currentQuestion.reponse;
      this.showAnswer = false;
    }
  }

  checkAnswer() {
    if (this.selectedOption === this.correctAnswer) {
      alert('Bonne réponse !');
      this.showAnswer = true;
    } else {
      alert('Mauvaise réponse. Veuillez réessayer.');
      this.showAnswer = true;
    }
  }

  selectAnswer(option: string) {
    this.selectedOption = option;
    console.log('Option sélectionnée :', this.selectedOption);
  }

  nextQuestion() {
    this.currentQuestionIndex += 1; // Incrémente l'index de la question actuelle

    if (this.currentQuestionIndex < this.questions.length) {
      this.updateCurrentQuestion(); // Met à jour la question actuelle à afficher
    } else {
      alert('Félicitations, vous avez terminé le quiz !'); // Message lorsque toutes les questions ont été répondues
    }
  }
}
