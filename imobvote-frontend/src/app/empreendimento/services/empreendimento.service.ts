import { Empreendimento } from './../models/empreendimento.model';
import { environment as env } from 'src/environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({ providedIn: 'root' })
export class EmpreendimentoService {

  constructor(private httpClient: HttpClient) {}

  listarEmpreendimentos(): Observable<Empreendimento[]> {
    return this.httpClient.get<Empreendimento[]>(env.baseUrl+'empreendimentos/listarEmpreendimentos');
  }
}
