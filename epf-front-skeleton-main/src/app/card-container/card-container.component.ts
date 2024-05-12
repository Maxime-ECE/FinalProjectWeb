import { Component, OnInit } from '@angular/core';
import { QuizzModel } from "../models/quizz.model";
import { QuizzService } from "../services/quizz.service"

@Component({
  selector: 'epf-card-container',
  templateUrl: './card-container.component.html',
  styleUrls: ['./card-container.component.scss']
})
export class CardContainerComponent implements OnInit {
  constructor(private quizzService: QuizzService) { }

  quizz: QuizzModel[] = [];
  ngOnInit(): void {
    this.quizzService.findAll().subscribe(tableau => this.quizz = tableau);
  }

}
