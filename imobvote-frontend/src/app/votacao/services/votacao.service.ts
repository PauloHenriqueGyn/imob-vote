import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment as env } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class VotacaoService {

  constructor(private httpClient: HttpClient) { }

  votoSim(id: string, email?: string) {
    return this.httpClient.post(env.baseUrl+'votacoes/insereSim', {id, email});
  }

  votoNao(id: string, email?: string) {
    return this.httpClient.post(env.baseUrl+'votacoes/insereNao', {id, email});
  }

}
