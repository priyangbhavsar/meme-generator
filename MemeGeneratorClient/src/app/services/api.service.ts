import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class APIService {
  API_SERVER_URL = "http://localhost:8080/"
  constructor(private httpClient: HttpClient) { }


  public sendGetRequest<T>(relativeUrl: string) {
    return this.httpClient.get<T>(this.API_SERVER_URL + relativeUrl);
  }
}
