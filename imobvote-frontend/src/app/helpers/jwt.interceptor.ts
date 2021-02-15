import { LoginService } from './../login/services/login.service';
import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {
    constructor(private loginService: LoginService) { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        // adicione o cabeçalho de autenticação com jwt se o usuário estiver conectado e a
        // solicitação for para o URL da API
        const login = this.loginService.loginValue;
        const isLoggedIn = login && login.token;
        const isApiUrl = request.url.startsWith(environment.baseUrl);
        if (isLoggedIn && isApiUrl) {
            request = request.clone({
                setHeaders: {
                    Authorization: `Bearer ${login.token}`
                }
            });
        }

        return next.handle(request);
    }
}
