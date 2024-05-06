import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateWithExistingQuizComponent } from './create-with-existing-quiz.component';

describe('CreateWithExistingQuizComponent', () => {
  let component: CreateWithExistingQuizComponent;
  let fixture: ComponentFixture<CreateWithExistingQuizComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateWithExistingQuizComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateWithExistingQuizComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
