import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
};

@Injectable({
  providedIn: 'root',
})
export class ImageService {
  constructor(private http: HttpClient) {}

  getImages() {
    return this.http.get('/server/api/images');
  }

  getImage(id: number) {
    return this.http.get('/server/api/images/' + id);
  }

  addImage(image) {
    let body = JSON.stringify(image);
    return this.http.post('/server/api/users', body, httpOptions);
  }
}
