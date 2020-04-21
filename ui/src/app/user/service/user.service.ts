import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
};

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient) {}

  getUsers(): Observable<any> {
    return this.http.get('/server/api/users');
  }

  getUser(id: number) {
    return this.http.get('/server/api/users/' + id);
  }

  createUserRegistration(user) {
    let body = JSON.stringify(user);
    return this.http.post('/server/api/users', body, httpOptions);
  }
}
