import { NgModule } from "@angular/core"
import { BrowserModule } from "@angular/platform-browser"

import { AppRoutingModule } from "app-routing.module"
import { AppComponent } from "app.component"
import { BrowserAnimationsModule } from "@angular/platform-browser/animations"
import { NavbarComponent } from "navbar/navbar.component"
import { MatListModule } from "@angular/material/list"
import { HomeComponent } from "home/home.component"
import { StudentsComponent } from "students/students.component"
import { StudentDetailsComponent } from "students/student-details/student-details.component"
import { FormsModule } from "@angular/forms"
import { MatIconModule } from "@angular/material/icon"
import { MatButtonModule } from "@angular/material/button"
import { MajorsComponent } from "majors/majors.component"
import { MajorStudentsComponent } from "majors/major-students/major-students.component"
import { HttpClientModule } from "@angular/common/http";
import { CardContainerComponent } from './card-container/card-container.component'
import { ClassementComponent } from './classement/classement.component';
import { CreerComponent } from './creer/creer.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { FooterComponent } from './footer/footer.component';
import { CreateOwnQuestionsComponent } from './create-own-questions/create-own-questions.component';
import { CreateWithExistingQuizComponent } from './create-with-existing-quiz/create-with-existing-quiz.component'
import { QuizzEnCours } from './quizz-en-cours/quizz-en-cours.component';
import { Connecté } from "./connecté/connecté.component"

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    StudentsComponent,
    StudentDetailsComponent,
    MajorsComponent,
    MajorStudentsComponent,
    CardContainerComponent,
    ClassementComponent,
    CreerComponent,
    ConnexionComponent,
    FooterComponent,
    CreateOwnQuestionsComponent,
    CreateWithExistingQuizComponent,
    QuizzEnCours,
    Connecté,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatListModule,
    FormsModule,
    MatIconModule,
    MatButtonModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {
}
