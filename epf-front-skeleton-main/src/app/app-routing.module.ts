import { NgModule } from "@angular/core"
import { RouterModule, Routes } from "@angular/router"
import { HomeComponent } from "home/home.component"
import { StudentsComponent } from "students/students.component"
import { StudentsResolver } from "students/students.resolver"
import { StudentDetailsComponent } from "students/student-details/student-details.component"
import { StudentDetailsResolver } from "students/student-details/student-details.resolver"
import { MajorsComponent } from "majors/majors.component"
import { MajorsResolver } from "majors/majors.resolver"
import { MajorStudentsResolver } from "majors/major-students/major-students.resolver"
import { MajorStudentsComponent } from "majors/major-students/major-students.component"
import { CardContainerComponent } from "./card-container/card-container.component"
import { ClassementComponent } from "./classement/classement.component"
import { CreerComponent } from "./creer/creer.component"
import { ConnexionComponent } from "./connexion/connexion.component"
import { FooterComponent } from "./footer/footer.component"
import { CreateOwnQuestionsComponent } from './create-own-questions/create-own-questions.component';
import { CreateWithExistingQuizComponent } from './create-with-existing-quiz/create-with-existing-quiz.component';
import { QuizzEnCours } from "./quizz-en-cours/quizz-en-cours.component"
import { Connecté } from "./connecté/connecté.component"


const routes: Routes = [
  { path: "", component: HomeComponent },
  { path: "card-container", component: CardContainerComponent },
  { path: 'classement', component: ClassementComponent },
  { path: 'connexion', component: ConnexionComponent },
  { path: 'creer', component: CreerComponent },
  { path: 'footer', component: FooterComponent },
  { path: 'create-own-questions', component: CreateOwnQuestionsComponent },
  { path: 'create-with-existing-quiz', component: CreateWithExistingQuizComponent },
  { path: 'connecté', component: Connecté},
  { path: 'quizz-en-cours/:id', component: QuizzEnCours },

  {
    path: "students",
    component: StudentsComponent,
    resolve: {
      students: StudentsResolver,
    },
  },
  {
    path: "student-details/:id",
    component: StudentDetailsComponent,
    resolve: {
      student: StudentDetailsResolver,
    },
  },
  {
    path: "majors",
    component: MajorsComponent,
    resolve: {
      majors: MajorsResolver,
    },
  },
  {
    path: "major-students/:id",
    component: MajorStudentsComponent,
    resolve: {
      studentsFromMajor: MajorStudentsResolver,
    },
  },
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
