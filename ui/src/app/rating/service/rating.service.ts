import { Injectable } from '@angular/core';
import { Rating } from '../rating';
import { Observable } from 'rxjs';
import { HttpHeaders, HttpClient } from '@angular/common/http';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
};

@Injectable({
  providedIn: 'root',
})
export class RatingService {
  constructor(private http: HttpClient) {}

  getRatings(): Observable<any[]> {
    return this.http.get<Rating[]>('/server/api/ratings');
  }

  getRating(id: number): Observable<Rating> {
    return this.http.get<Rating>('/server/api/ratings/' + id);
  }

  createRatingRegistration(rating) {
    let body = JSON.stringify(rating);
    return this.http.post('/server/api/ratings', body, httpOptions);
  }
}
