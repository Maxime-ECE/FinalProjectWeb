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
  quizz: any = {}; // Utilisez un type approprié pour vos objets quizz
  selectedOption: string = '';
  correctAnswer: string = '';
  showAnswer: boolean = false;

  constructor(private router: Router, private quizzService: QuizzService, private http: HttpClient) { }

  ngOnInit(): void {
    this.quizzService.getQuizzWithQuestionsAndAnswers().subscribe(data => {
      this.quizz = data;
      this.correctAnswer = this.quizz['Mon super quizz'][4].reponse;
      console.log(data);
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

  }


}
