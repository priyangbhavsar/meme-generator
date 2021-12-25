import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExploreMemeComponent } from './explore-meme.component';

describe('ExploreMemeComponent', () => {
  let component: ExploreMemeComponent;
  let fixture: ComponentFixture<ExploreMemeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExploreMemeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExploreMemeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
