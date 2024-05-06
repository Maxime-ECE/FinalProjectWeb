import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateOwnQuestionsComponent } from './create-own-questions.component';

describe('CreateOwnQuestionsComponent', () => {
  let component: CreateOwnQuestionsComponent;
  let fixture: ComponentFixture<CreateOwnQuestionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateOwnQuestionsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateOwnQuestionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
