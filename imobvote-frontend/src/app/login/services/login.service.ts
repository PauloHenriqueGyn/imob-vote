import { environment as env } from 'src/environments/environment';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Login } from '../models';

@Injectable({ providedIn: 'root' })
export class LoginService {
  private loginSubject: BehaviorSubject<Login>;
  public login: Observable<Login>;

  constructor(
    private router: Router,
    private http: HttpClient
  ) {
    this.loginSubject = new BehaviorSubject<Login>(JSON.parse(localStorage.getItem('login') || '{}'));
    this.login = this.loginSubject.asObservable();
  }

  public get loginValue(): Login {
    return this.loginSubject.value;
  }

  acesso(login: Login) {
    return this.http.post(env.baseUrl + 'login', login)
      .pipe(map(login => {
        // armazene os detalhes do login e o token jwt no armazenamento local para manter o usuário conectado
        localStorage.setItem('login', JSON.stringify(login));
        this.loginSubject.next(login);
        return login;
      }));
  }

  sair() {
    // remove o usuário do armazenamento local e define o usuário atual como nulo
    localStorage.removeItem('login');
    this.loginSubject.next(({} as Login));
    this.router.navigate(['/login/login']);
  }

}
