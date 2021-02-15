import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth';
import { PrincipalComponent } from './principal';

const routes: Routes = [
  { path: '', component: PrincipalComponent, canActivate: [AuthGuard] },
  // { path: 'usuario', loadChildren: usersModule, canActivate: [AuthGuard] },
  // { path: 'produto', loadChildren: () => import('./produto/produto.module').then(m => m.ProdutoModule), canActivate: [AuthGuard] },
  { path: 'login', loadChildren: () => import('./login/login.module').then(m => m.LoginModule), },

  // otherwise redirect to home
  { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
