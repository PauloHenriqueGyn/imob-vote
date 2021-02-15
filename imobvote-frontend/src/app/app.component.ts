import { Component } from '@angular/core';
import { Login, LoginService } from './login';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  login: Login;

  constructor(private loginService: LoginService) {
    this.loginService.login.subscribe(x => this.login = x);
  }

  sair() {
    this.loginService.sair();
  }
}
