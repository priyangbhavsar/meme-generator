import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommonService {

  constructor() { }

  componentLoading = new BehaviorSubject<boolean>(true);

  getLoader(): Observable<boolean> {
    return this.componentLoading.asObservable();
  }
}
