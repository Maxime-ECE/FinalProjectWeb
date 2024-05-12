import { Component, OnInit } from '@angular/core';
import { UserService } from "../services/user.service";
import { Users } from "../models/users.model";

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.scss']
})
export class ConnexionComponent implements OnInit {
  email: string = '';
  password: string = '';
  errorMessage: string = '';
  users: Users[] = []; // Variable pour stocker les données d'utilisateurs
  isLoggedIn: boolean = false; // Variable pour suivre l'état de connexion

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.userService.findAll().subscribe(
      (users: Users[]) => {
        this.users = users;
      },
      (error) => {
        console.error('Une erreur s\'est produite :', error);
      }
    );
  }

  login(): void {

    // Vérifiez si l'email et le mot de passe correspondent à ceux d'un utilisateur
    const foundUser = this.users.find(user => user.email.toLowerCase() === this.email.toLowerCase() && user.password_mdp.trim() === this.password.trim());

    if (foundUser) {
      // Enregistrez les informations de l'utilisateur dans la sessionStorage
      const currentTime = new Date().getTime();
      const sessionData = {
        user: foundUser,
        expiryTime: currentTime + (5 * 60 * 1000) // 5 minutes en millisecondes
      };
      sessionStorage.setItem('sessionData', JSON.stringify(sessionData));

      // Mettez à jour l'état de connexion
      this.isLoggedIn = true;
      console.log('Connexion réussie !');

      // Démarrez une minuterie pour surveiller l'expiration de la session
      this.startSessionTimer();
    } else {
      // Si l'utilisateur n'est pas trouvé, affichez un message d'erreur
      this.errorMessage = 'Nom d\'utilisateur ou mot de passe incorrect.';
    }
  }

  startSessionTimer(): void {
    // Obtenez les données de la session depuis la sessionStorage
    const sessionDataString = sessionStorage.getItem('sessionData');
    const sessionData = sessionDataString ? JSON.parse(sessionDataString) : null;

    if (sessionData) {
      // Calculez le temps restant avant l'expiration de la session
      const currentTime = new Date().getTime();
      const timeRemaining = sessionData.expiryTime - currentTime;

      // Démarrez une minuterie pour déconnecter l'utilisateur lorsque la session expire
      setTimeout(() => {
        this.logout();
      }, timeRemaining);
    }
  }

  logout(): void {
    // Déconnectez l'utilisateur en supprimant les informations de session
    sessionStorage.removeItem('sessionData');
    this.isLoggedIn = false;
    console.log('Déconnexion réussie.');
  }


}
