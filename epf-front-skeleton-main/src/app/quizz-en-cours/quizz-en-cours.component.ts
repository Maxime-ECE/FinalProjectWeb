import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { QuizzService } from "../services/quizz.service"
import { QuizzModel } from "../models/quizz.model"
import { HttpClient } from "@angular/common/http"


@Component({
  selector: 'epf-quizz-en-cours',
  templateUrl: './quizz-en-cours.component.html',
  styleUrls: ['./quizz-en-cours.component.scss']
})
export class QuizzEnCours implements OnInit {
  quizz: any = {};
  selectedOption: string = '';
  correctAnswer: string = '';
  showAnswer: boolean = false;
  currentQuizId: any = 1;
  currentQuestionIndex: number = 0;
  name : string = '';
  constructor(private quizzService: QuizzService) { }

  ngOnInit(): void {
    this.quizzService.getQuizTitleQuestionsAndAnswersWithId().subscribe(data => {
      this.quizz = data;
      if (this.quizz && this.quizz.length > 0) {
        const actualQestion = this.quizz.find((quiz: any) => quiz.id === this.currentQuizId);
        if (actualQestion) {
          this.name = actualQestion.titre;
          this.correctAnswer = actualQestion.reponse;
          console.log(actualQestion);
        } else {
          console.log("Le premier quiz n'a pas été trouvé.");
        }
      }
    });
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

    if (this.currentQuestionIndex < this.quizz.length) {
      const question = this.quizz[this.currentQuestionIndex]; // Récupère la prochaine question
   console.log(question);
      this.selectedOption = ''; // Réinitialise la réponse sélectionnée
      this.correctAnswer = question.reponse; // Met à jour la réponse correcte
      this.showAnswer = false; // Cache la réponse
    } else {
      alert('Félicitations, vous avez terminé le quiz !'); // Message lorsque toutes les questions ont été répondues
    }
  }



}
