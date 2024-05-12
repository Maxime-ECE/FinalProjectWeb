import { Router } from '@angular/router';
import { Component } from '@angular/core';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.scss']
})
export class ConnexionComponent {
  username: string = '';
  password: string = '';

  constructor(private router: Router) {}

  login() {
    // Vérifiez les informations d'identification ici
    // Si les informations sont correctes, redirigez vers la page connectée
    this.router.navigate(['../connecté', { username: this.username }]);
  }
}
