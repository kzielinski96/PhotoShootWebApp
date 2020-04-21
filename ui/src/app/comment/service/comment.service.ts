import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Comment } from '../comment';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
};

@Injectable({
  providedIn: 'root',
})
export class CommentService {
  constructor(private http: HttpClient) {}

  getComments(): Observable<any[]> {
    return this.http.get<Comment[]>('/server/api/comments');
  }

  getComment(id: number): Observable<Comment> {
    return this.http.get<Comment>('/server/api/comments/' + id);
  }

  createCommentRegistration(comment) {
    let body = JSON.stringify(comment);
    return this.http.post('/server/api/comments', body, httpOptions);
  }
}
