-- =============================================
-- Grades (슬라이드 11)
-- =============================================
INSERT INTO grades (id, name, order_num) VALUES (1, '3학년', 1);
INSERT INTO grades (id, name, order_num) VALUES (2, '4학년', 2);
INSERT INTO grades (id, name, order_num) VALUES (3, '5학년', 3);
INSERT INTO grades (id, name, order_num) VALUES (4, '6학년', 4);

-- =============================================
-- Units (슬라이드 12)
-- =============================================

-- 3학년 (추후 교육과정에 맞춰 보강)
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (1, 1, '운동 체력을 알아보아요', '3학년 운동체력 단원', 1);
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (2, 1, '뜀틀을 알아보아요', '3학년 뜀틀 단원', 2);
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (3, 1, '표현 활동을 알아보아요', '3학년 표현활동 단원', 3);

-- 4학년 (추후 교육과정에 맞춰 보강)
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (4, 2, '운동 체력을 알아보아요', '4학년 운동체력 단원', 1);
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (5, 2, '높이뛰기를 알아보아요', '4학년 높이뛰기 단원', 2);
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (6, 2, '축구형 게임을 알아보아요', '4학년 축구 단원', 3);
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (7, 2, '표현 활동을 알아보아요', '4학년 표현활동 단원', 4);

-- 5학년 (추후 교육과정에 맞춰 보강)
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (8, 3, '운동 체력을 알아보아요', '5학년 운동체력 단원', 1);
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (9, 3, '배구형 게임을 알아보아요', '5학년 배구 단원', 2);
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (10, 3, '농구형 게임을 알아보아요', '5학년 농구 단원', 3);
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (11, 3, '댄스 스포츠를 알아보아요', '5학년 댄스스포츠 단원', 4);

-- 6학년 (슬라이드 12 — 와이어프레임 기준)
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (12, 4, '운동 체력을 알아보아요', '6학년 운동체력 단원', 1);
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (13, 4, '높이뛰기를 알아보아요', '6학년 높이뛰기 단원', 2);
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (14, 4, '축구형 게임을 알아보아요', '6학년 축구 단원', 3);
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (15, 4, '배구형 게임을 알아보아요', '6학년 배구 단원', 4);
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (16, 4, '댄스 스포츠를 알아보아요', '6학년 댄스스포츠 단원', 5);

-- =============================================
-- Categories (슬라이드 13 — 각 단원마다 동일한 5개 카테고리)
-- =============================================

-- Unit 1 (3학년 운동체력)
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (1, 1, '집에서도 해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (2, 1, '체력 기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (3, 1, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (4, 1, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (5, 1, '게임', 'GAME', 5);

-- Unit 2 (3학년 뜀틀)
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (6, 2, '집에서도 해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (7, 2, '체력 기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (8, 2, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (9, 2, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (10, 2, '게임', 'GAME', 5);

-- Unit 3 (3학년 표현활동)
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (11, 3, '집에서도 해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (12, 3, '체력 기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (13, 3, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (14, 3, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (15, 3, '게임', 'GAME', 5);

-- Unit 4 (4학년 운동체력)
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (16, 4, '집에서도 해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (17, 4, '체력 기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (18, 4, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (19, 4, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (20, 4, '게임', 'GAME', 5);

-- Unit 5 (4학년 높이뛰기)
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (21, 5, '집에서도 해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (22, 5, '체력 기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (23, 5, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (24, 5, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (25, 5, '게임', 'GAME', 5);

-- Unit 6 (4학년 축구)
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (26, 6, '집에서도 해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (27, 6, '체력 기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (28, 6, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (29, 6, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (30, 6, '게임', 'GAME', 5);

-- Unit 7 (4학년 표현활동)
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (31, 7, '집에서도 해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (32, 7, '체력 기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (33, 7, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (34, 7, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (35, 7, '게임', 'GAME', 5);

-- Unit 8 (5학년 운동체력)
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (36, 8, '집에서도 해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (37, 8, '체력 기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (38, 8, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (39, 8, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (40, 8, '게임', 'GAME', 5);

-- Unit 9 (5학년 배구)
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (41, 9, '집에서도 해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (42, 9, '체력 기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (43, 9, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (44, 9, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (45, 9, '게임', 'GAME', 5);

-- Unit 10 (5학년 농구)
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (46, 10, '집에서도 해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (47, 10, '체력 기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (48, 10, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (49, 10, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (50, 10, '게임', 'GAME', 5);

-- Unit 11 (5학년 댄스스포츠)
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (51, 11, '집에서도 해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (52, 11, '체력 기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (53, 11, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (54, 11, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (55, 11, '게임', 'GAME', 5);

-- Unit 12 (6학년 운동체력)
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (56, 12, '집에서도 해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (57, 12, '체력 기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (58, 12, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (59, 12, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (60, 12, '게임', 'GAME', 5);

-- Unit 13 (6학년 높이뛰기)
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (61, 13, '집에서도 해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (62, 13, '체력 기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (63, 13, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (64, 13, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (65, 13, '게임', 'GAME', 5);

-- Unit 14 (6학년 축구형 게임) ★ 슬라이드 13 기준
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (66, 14, '집에서도 해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (67, 14, '체력 기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (68, 14, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (69, 14, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (70, 14, '게임', 'GAME', 5);

-- Unit 15 (6학년 배구형 게임)
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (71, 15, '집에서도 해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (72, 15, '체력 기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (73, 15, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (74, 15, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (75, 15, '게임', 'GAME', 5);

-- Unit 16 (6학년 댄스스포츠)
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (76, 16, '집에서도 해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (77, 16, '체력 기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (78, 16, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (79, 16, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (80, 16, '게임', 'GAME', 5);

-- =============================================
-- Activities — 3학년 운동체력 (Unit 1)
-- =============================================
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (1, 1, '줄넘기 100개 도전', '집에서 줄넘기 100개에 도전해보세요', '3학년', '1. 운동체력', '줄넘기를 준비하고, 연속으로 100개를 넘는 것을 목표로 합니다. 쉬지 않고 도전해보세요!', 1);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (2, 1, '스트레칭 루틴', '매일 아침 스트레칭 루틴을 따라해보세요', '3학년', '1. 운동체력', '목, 어깨, 허리, 다리 순서로 천천히 스트레칭합니다. 각 동작 10초씩 유지하세요.', 2);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (3, 2, '왕복달리기', '20m 왕복달리기 체력 측정', '3학년', '1. 운동체력', '출발선에서 시작하여 20m 지점을 터치하고 돌아옵니다. 최대한 빠르게!', 1);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (4, 2, '윗몸일으키기', '1분 동안 윗몸일으키기', '3학년', '1. 운동체력', '바닥에 누워 무릎을 구부리고, 양손을 가슴에 교차합니다. 상체를 일으켜 무릎에 닿게 합니다.', 2);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (5, 3, '체력 측정하기', '기초 체력을 측정합니다', '3학년', '1. 운동체력', '선생님의 안내에 따라 각 종목별 체력을 측정합니다.', 1);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (6, 4, '체력 측정 평가', '체력 향상도를 평가합니다', '3학년', '1. 운동체력', '초기 체력 측정과 비교하여 얼마나 향상되었는지 평가합니다.', 1);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (7, 5, '꼬리잡기 게임', '꼬리를 잡는 체력 게임', '3학년', '1. 운동체력', '허리에 꼬리(수건)를 달고, 상대방의 꼬리를 잡는 게임입니다. 끝까지 살아남으세요!', 1);

-- =============================================
-- Activities — 3학년 뜀틀 (Unit 2)
-- =============================================
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (8, 6, '양발 모아 뛰기', '양발을 모아 장애물 넘기 연습', '3학년', '2. 뜀틀', '낮은 장애물(쿠션, 베개)을 놓고 양발을 모아 뛰어넘는 연습을 합니다.', 1);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (9, 7, '팔 힘 기르기', '팔굽혀펴기로 팔 힘 기르기', '3학년', '2. 뜀틀', '무릎을 대고 팔굽혀펴기를 합니다. 팔을 충분히 굽혔다 펴세요.', 1);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (10, 8, '뜀틀 기본 동작', '뜀틀의 기본 동작을 배웁니다', '3학년', '2. 뜀틀', '도움닫기 → 발구름 → 착손 → 넘기 → 착지 순서를 배웁니다.', 1);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (11, 9, '뜀틀 실기 평가', '뜀틀 넘기 실기 평가', '3학년', '2. 뜀틀', '정해진 높이의 뜀틀을 안전하고 정확한 자세로 넘는지 평가합니다.', 1);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (12, 10, '장애물 릴레이', '다양한 장애물을 넘는 릴레이 게임', '3학년', '2. 뜀틀', '팀을 나누어 뜀틀, 매트, 허들 등 다양한 장애물을 넘는 릴레이입니다.', 1);

-- =============================================
-- Activities — 4학년 축구 (Unit 6)
-- =============================================
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (13, 26, '볼 터치 연습', '발로 공 다루기 연습', '4학년', '3. 축구', '공을 발바닥, 발등, 발안쪽으로 번갈아 터치합니다.', 1);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (14, 26, '벽 패스 연습', '벽에 공을 차고 받기', '4학년', '3. 축구', '벽에서 3m 떨어져서 공을 차고 돌아오는 공을 받는 연습을 합니다.', 2);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (15, 28, '인사이드 킥 배우기', '발 안쪽으로 패스하기', '4학년', '3. 축구', '발 안쪽을 이용하여 정확하게 패스하는 방법을 배웁니다.', 1);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (16, 28, '드리블 배우기', '공을 몰고 달리기', '4학년', '3. 축구', '발등과 발안쪽을 이용하여 공을 컨트롤하며 달리는 방법을 배웁니다.', 2);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (17, 30, '미니 축구 게임', '4:4 미니 축구 경기', '4학년', '3. 축구', '작은 코트에서 4명씩 팀을 이루어 미니 축구 경기를 합니다.', 1);

-- =============================================
-- Activities — 5학년 배구 (Unit 9)
-- =============================================
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (18, 41, '셀프 토스 연습', '혼자서 공 올리기 연습', '5학년', '2. 배구', '배구공을 양손으로 위로 올리고 받는 연습을 합니다. 연속으로 최대한 많이 해보세요.', 1);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (19, 43, '언더핸드 패스', '언더핸드 패스 기본 자세 배우기', '5학년', '2. 배구', '양손을 모아 팔뚝으로 공을 올바르게 받아 올리는 방법을 배웁니다.', 1);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (20, 43, '오버핸드 패스', '오버핸드 패스 배우기', '5학년', '2. 배구', '양손 손가락으로 이마 위에서 공을 밀어 올리는 방법을 배웁니다.', 2);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (21, 45, '미니 배구 게임', '3:3 미니 배구 경기', '5학년', '2. 배구', '낮은 네트에서 3명씩 팀을 이루어 미니 배구 게임을 합니다.', 1);

-- =============================================
-- ★ Activities — 6학년 축구형 게임 (Unit 14)
-- ★ 와이어프레임 슬라이드 14~21 기반 정확한 데이터
-- =============================================

-- [집에서도 해요] HOME (category 66) — 슬라이드 14~16
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num)
VALUES (22, 66, '양말 공 골인', '양말로 만든 공으로 골인 연습', '6학년', '3. 축구형 게임',
'돌돌 만 양말을 거실 한쪽에 둔 바구니(골대) 안으로 발 안쪽을 이용해 정확히 밀어넣는 연습을 합니다.', 1);

INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num)
VALUES (23, 66, '발로 문 닫기', '발 컨트롤을 활용한 집 놀이', '6학년', '3. 축구형 게임',
'(상세 안내 추후 입력)', 2);

-- [체력 기르기] FITNESS (category 67) — 슬라이드 17~19
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num)
VALUES (24, 67, '스쿼트', '디딤발 파워 기르기', '6학년', '3. 축구형 게임',
'사진에 맞는 동작을 10회씩 3세트 반복합니다. 무릎이 발끝보다 앞으로 나오지 않도록 주의하세요.', 1);

INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num)
VALUES (25, 67, '런지', '디딤발 파워 기르기', '6학년', '3. 축구형 게임',
'(상세 안내 추후 입력)', 2);

INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num)
VALUES (26, 67, '한 발로 서기', '평형성 기르기', '6학년', '3. 축구형 게임',
'(상세 안내 추후 입력)', 3);

INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num)
VALUES (27, 67, '제자리 뛰기', '민첩성 기르기', '6학년', '3. 축구형 게임',
'(상세 안내 추후 입력)', 4);

-- [수업] CLASS (category 68) — 슬라이드 20~21
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num)
VALUES (28, 68, '인사이드 패스', '발 안쪽을 활용한 정확한 패스', '6학년', '3. 축구형 게임',
'발의 안쪽 넓은 면을 활용해 원하는 방향으로 공을 정확하게 보냅니다.', 1);

INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num)
VALUES (29, 68, '드리블', '공을 몰고 이동하기', '6학년', '3. 축구형 게임',
'(상세 안내 추후 입력)', 2);

-- [평가] ASSESSMENT (category 69) — 추후 콘텐츠 추가
-- [게임] GAME (category 70) — 추후 콘텐츠 추가

-- =============================================
-- Activities — 6학년 운동체력 (Unit 12)
-- =============================================
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num)
VALUES (30, 56, '버피 테스트', '버피 운동 도전하기', '6학년', '1. 운동체력',
'서기 → 쪼그리기 → 팔굽혀펴기 → 쪼그리기 → 점프 순서로 수행합니다.', 1);

INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num)
VALUES (31, 56, '홈 트레이닝', '집에서 하는 전신 운동', '6학년', '1. 운동체력',
'스쿼트, 런지, 팔굽혀펴기, 플랭크를 각각 10회씩 3세트 수행합니다.', 2);

INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num)
VALUES (32, 57, '1000m 달리기', '1000m 오래달리기', '6학년', '1. 운동체력',
'운동장 트랙을 이용하여 1000m를 달립니다. 일정한 페이스를 유지하세요.', 1);

INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num)
VALUES (33, 58, '인터벌 트레이닝', '고강도 인터벌 운동', '6학년', '1. 운동체력',
'30초 전력 달리기 + 30초 걷기를 반복하는 인터벌 트레이닝을 합니다.', 1);
