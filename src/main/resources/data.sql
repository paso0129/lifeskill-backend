-- =============================================
-- Grades
-- =============================================
INSERT INTO grades (id, name, order_num) VALUES (1, '3학년', 1);
INSERT INTO grades (id, name, order_num) VALUES (2, '4학년', 2);
INSERT INTO grades (id, name, order_num) VALUES (3, '5학년', 3);
INSERT INTO grades (id, name, order_num) VALUES (4, '6학년', 4);

-- =============================================
-- Units - 3학년
-- =============================================
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (1, 1, '운동체력', '3학년 운동체력 단원', 1);
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (2, 1, '뜀틀', '3학년 뜀틀 단원', 2);
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (3, 1, '표현활동', '3학년 표현활동 단원', 3);

-- Units - 4학년
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (4, 2, '운동체력', '4학년 운동체력 단원', 1);
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (5, 2, '높이뛰기', '4학년 높이뛰기 단원', 2);
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (6, 2, '축구', '4학년 축구 단원', 3);
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (7, 2, '표현활동', '4학년 표현활동 단원', 4);

-- Units - 5학년
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (8, 3, '운동체력', '5학년 운동체력 단원', 1);
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (9, 3, '배구', '5학년 배구 단원', 2);
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (10, 3, '농구', '5학년 농구 단원', 3);
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (11, 3, '댄스스포츠', '5학년 댄스스포츠 단원', 4);

-- Units - 6학년
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (12, 4, '운동체력', '6학년 운동체력 단원', 1);
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (13, 4, '핸드볼', '6학년 핸드볼 단원', 2);
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (14, 4, '플래그풋볼', '6학년 플래그풋볼 단원', 3);
INSERT INTO units (id, grade_id, name, description, order_num) VALUES (15, 4, '댄스스포츠', '6학년 댄스스포츠 단원', 4);

-- =============================================
-- Categories for Unit 1 (3학년 운동체력)
-- =============================================
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (1, 1, '집에서도해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (2, 1, '체력기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (3, 1, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (4, 1, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (5, 1, '게임', 'GAME', 5);

-- Categories for Unit 2 (3학년 뜀틀)
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (6, 2, '집에서도해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (7, 2, '체력기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (8, 2, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (9, 2, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (10, 2, '게임', 'GAME', 5);

-- Categories for Unit 3 (3학년 표현활동)
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (11, 3, '집에서도해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (12, 3, '체력기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (13, 3, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (14, 3, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (15, 3, '게임', 'GAME', 5);

-- Categories for Unit 4 (4학년 운동체력)
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (16, 4, '집에서도해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (17, 4, '체력기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (18, 4, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (19, 4, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (20, 4, '게임', 'GAME', 5);

-- Categories for Unit 5 (4학년 높이뛰기)
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (21, 5, '집에서도해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (22, 5, '체력기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (23, 5, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (24, 5, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (25, 5, '게임', 'GAME', 5);

-- Categories for Unit 6 (4학년 축구)
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (26, 6, '집에서도해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (27, 6, '체력기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (28, 6, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (29, 6, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (30, 6, '게임', 'GAME', 5);

-- Categories for Unit 7 (4학년 표현활동)
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (31, 7, '집에서도해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (32, 7, '체력기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (33, 7, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (34, 7, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (35, 7, '게임', 'GAME', 5);

-- Categories for Unit 8 (5학년 운동체력)
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (36, 8, '집에서도해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (37, 8, '체력기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (38, 8, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (39, 8, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (40, 8, '게임', 'GAME', 5);

-- Categories for Unit 9 (5학년 배구)
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (41, 9, '집에서도해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (42, 9, '체력기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (43, 9, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (44, 9, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (45, 9, '게임', 'GAME', 5);

-- Categories for Unit 10 (5학년 농구)
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (46, 10, '집에서도해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (47, 10, '체력기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (48, 10, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (49, 10, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (50, 10, '게임', 'GAME', 5);

-- Categories for Unit 11 (5학년 댄스스포츠)
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (51, 11, '집에서도해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (52, 11, '체력기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (53, 11, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (54, 11, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (55, 11, '게임', 'GAME', 5);

-- Categories for Unit 12 (6학년 운동체력)
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (56, 12, '집에서도해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (57, 12, '체력기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (58, 12, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (59, 12, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (60, 12, '게임', 'GAME', 5);

-- Categories for Unit 13 (6학년 핸드볼)
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (61, 13, '집에서도해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (62, 13, '체력기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (63, 13, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (64, 13, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (65, 13, '게임', 'GAME', 5);

-- Categories for Unit 14 (6학년 플래그풋볼)
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (66, 14, '집에서도해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (67, 14, '체력기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (68, 14, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (69, 14, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (70, 14, '게임', 'GAME', 5);

-- Categories for Unit 15 (6학년 댄스스포츠)
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (71, 15, '집에서도해요', 'HOME', 1);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (72, 15, '체력기르기', 'FITNESS', 2);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (73, 15, '수업', 'CLASS', 3);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (74, 15, '평가', 'ASSESSMENT', 4);
INSERT INTO categories (id, unit_id, name, type, order_num) VALUES (75, 15, '게임', 'GAME', 5);

-- =============================================
-- Activities for Unit 1 (3학년 운동체력)
-- =============================================
-- HOME (category 1)
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (1, 1, '줄넘기 100개 도전', '집에서 줄넘기 100개에 도전해보세요', '3학년', '회', '줄넘기를 준비하고, 연속으로 100개를 넘는 것을 목표로 합니다. 쉬지 않고 도전해보세요!', 1);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (2, 1, '스트레칭 루틴', '매일 아침 스트레칭 루틴을 따라해보세요', '3학년', '분', '목, 어깨, 허리, 다리 순서로 천천히 스트레칭합니다. 각 동작 10초씩 유지하세요.', 2);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (3, 1, '제자리 뛰기', '제자리에서 높이 뛰기 연습', '3학년', '회', '무릎을 충분히 구부렸다가 힘차게 뛰어오릅니다. 착지할 때 무릎을 살짝 구부려 충격을 줄이세요.', 3);

-- FITNESS (category 2)
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (4, 2, '왕복달리기', '20m 왕복달리기 체력 측정', '3학년', '초', '출발선에서 시작하여 20m 지점을 터치하고 돌아옵니다. 최대한 빠르게!', 1);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (5, 2, '윗몸일으키기', '1분 동안 윗몸일으키기', '3학년', '회', '바닥에 누워 무릎을 구부리고, 양손을 가슴에 교차합니다. 상체를 일으켜 무릎에 닿게 합니다.', 2);

-- CLASS (category 3)
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (6, 3, '체력 측정하기', '기초 체력을 측정합니다', '3학년', NULL, '선생님의 안내에 따라 각 종목별 체력을 측정합니다.', 1);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (7, 3, '체력 운동 배우기', '다양한 체력 운동 방법을 배웁니다', '3학년', NULL, '근력, 유연성, 심폐지구력을 기르는 다양한 운동을 배워봅니다.', 2);

-- ASSESSMENT (category 4)
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (8, 4, '체력 측정 평가', '체력 향상도를 평가합니다', '3학년', '점', '초기 체력 측정과 비교하여 얼마나 향상되었는지 평가합니다.', 1);

-- GAME (category 5)
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (9, 5, '꼬리잡기 게임', '꼬리를 잡는 체력 게임', '3학년', NULL, '허리에 꼬리(수건)를 달고, 상대방의 꼬리를 잡는 게임입니다. 끝까지 살아남으세요!', 1);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (10, 5, '무궁화 꽃이 피었습니다', '전통 놀이를 활용한 체력 게임', '3학년', NULL, '술래가 "무궁화 꽃이 피었습니다"를 외치는 동안 움직이고, 돌아보면 멈춥니다.', 2);

-- =============================================
-- Activities for Unit 2 (3학년 뜀틀)
-- =============================================
-- HOME (category 6)
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (11, 6, '양발 모아 뛰기', '양발을 모아 장애물 넘기 연습', '3학년', '회', '낮은 장애물(쿠션, 베개)을 놓고 양발을 모아 뛰어넘는 연습을 합니다.', 1);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (12, 6, '손짚고 넘기 연습', '침대나 소파에서 손짚고 넘기', '3학년', '회', '안전한 곳에서 양손을 짚고 다리를 넘기는 연습을 합니다.', 2);

-- FITNESS (category 7)
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (13, 7, '팔 힘 기르기', '팔굽혀펴기로 팔 힘 기르기', '3학년', '회', '무릎을 대고 팔굽혀펴기를 합니다. 팔을 충분히 굽혔다 펴세요.', 1);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (14, 7, '도약력 기르기', '제자리 멀리뛰기 연습', '3학년', 'cm', '양발을 어깨너비로 벌리고, 팔을 크게 흔들며 최대한 멀리 뜁니다.', 2);

-- CLASS (category 8)
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (15, 8, '뜀틀 기본 동작', '뜀틀의 기본 동작을 배웁니다', '3학년', NULL, '도움닫기 → 발구름 → 착손 → 넘기 → 착지 순서를 배웁니다.', 1);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (16, 8, '뜀틀 넘기', '단계별 뜀틀 넘기 연습', '3학년', NULL, '낮은 단수부터 시작하여 점차 높이를 올려가며 연습합니다.', 2);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (17, 8, '다양한 뜀틀 기술', '개각뛰기, 폐각뛰기 등 배우기', '3학년', NULL, '다리를 벌려 넘는 개각뛰기와 다리를 모아 넘는 폐각뛰기를 배웁니다.', 3);

-- ASSESSMENT (category 9)
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (18, 9, '뜀틀 실기 평가', '뜀틀 넘기 실기 평가', '3학년', '점', '정해진 높이의 뜀틀을 안전하고 정확한 자세로 넘는지 평가합니다.', 1);

-- GAME (category 10)
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (19, 10, '장애물 릴레이', '다양한 장애물을 넘는 릴레이 게임', '3학년', NULL, '팀을 나누어 뜀틀, 매트, 허들 등 다양한 장애물을 넘는 릴레이입니다.', 1);

-- =============================================
-- Activities for Unit 4 (4학년 운동체력)
-- =============================================
-- HOME (category 16)
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (20, 16, '플랭크 도전', '플랭크 자세 유지하기', '4학년', '초', '엎드려 팔꿈치와 발끝으로 몸을 지탱합니다. 몸을 일직선으로 유지하세요.', 1);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (21, 16, '계단 오르기', '계단을 이용한 체력 운동', '4학년', '층', '아파트 계단을 걸어서 올라갑니다. 목표 층수를 정해 도전하세요.', 2);

-- FITNESS (category 17)
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (22, 17, '오래달리기', '운동장 5바퀴 달리기', '4학년', '분', '일정한 속도로 운동장 5바퀴를 달립니다. 중간에 걷지 않도록 노력하세요.', 1);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (23, 17, '앉아 윗몸 앞으로 굽히기', '유연성 측정', '4학년', 'cm', '다리를 펴고 앉아서 상체를 앞으로 최대한 숙입니다.', 2);

-- CLASS (category 18)
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (24, 18, '서킷 트레이닝', '여러 운동을 순환하며 체력 기르기', '4학년', NULL, '6개 스테이션을 돌며 다양한 체력 운동을 수행합니다.', 1);

-- ASSESSMENT (category 19)
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (25, 19, '체력 종합 평가', '체력 요소별 종합 평가', '4학년', '점', '근력, 유연성, 순발력, 심폐지구력 등을 종합 평가합니다.', 1);

-- GAME (category 20)
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (26, 20, '팀 릴레이 경주', '팀별 릴레이 경주', '4학년', NULL, '4명이 한 팀이 되어 바통을 넘기며 릴레이 경주를 합니다.', 1);

-- =============================================
-- Activities for Unit 6 (4학년 축구)
-- =============================================
-- HOME (category 26)
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (27, 26, '볼 터치 연습', '발로 공 다루기 연습', '4학년', '회', '공을 발바닥, 발등, 발안쪽으로 번갈아 터치합니다.', 1);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (28, 26, '벽 패스 연습', '벽에 공을 차고 받기', '4학년', '회', '벽에서 3m 떨어져서 공을 차고 돌아오는 공을 받는 연습을 합니다.', 2);

-- CLASS (category 28)
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (29, 28, '인사이드 킥 배우기', '발 안쪽으로 패스하기', '4학년', NULL, '발 안쪽을 이용하여 정확하게 패스하는 방법을 배웁니다.', 1);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (30, 28, '드리블 배우기', '공을 몰고 달리기', '4학년', NULL, '발등과 발안쪽을 이용하여 공을 컨트롤하며 달리는 방법을 배웁니다.', 2);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (31, 28, '슈팅 배우기', '골대를 향해 슈팅하기', '4학년', NULL, '정확하고 강하게 골대를 향해 슈팅하는 방법을 배웁니다.', 3);

-- GAME (category 30)
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (32, 30, '미니 축구 게임', '4:4 미니 축구 경기', '4학년', NULL, '작은 코트에서 4명씩 팀을 이루어 미니 축구 경기를 합니다.', 1);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (33, 30, '패스 릴레이 게임', '팀별 패스 릴레이', '4학년', NULL, '팀별로 정확한 패스를 연결하여 골대까지 가장 빨리 도달하는 게임입니다.', 2);

-- =============================================
-- Activities for Unit 9 (5학년 배구)
-- =============================================
-- HOME (category 41)
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (34, 41, '셀프 토스 연습', '혼자서 공 올리기 연습', '5학년', '회', '배구공을 양손으로 위로 올리고 받는 연습을 합니다. 연속으로 최대한 많이 해보세요.', 1);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (35, 41, '벽 언더핸드 패스', '벽을 이용한 언더핸드 패스 연습', '5학년', '회', '벽에서 2m 떨어져서 언더핸드 패스로 공을 벽에 보내고 받습니다.', 2);

-- CLASS (category 43)
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (36, 43, '언더핸드 패스', '언더핸드 패스 기본 자세 배우기', '5학년', NULL, '양손을 모아 팔뚝으로 공을 올바르게 받아 올리는 방법을 배웁니다.', 1);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (37, 43, '오버핸드 패스', '오버핸드 패스 배우기', '5학년', NULL, '양손 손가락으로 이마 위에서 공을 밀어 올리는 방법을 배웁니다.', 2);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (38, 43, '서브 배우기', '언더핸드 서브 배우기', '5학년', NULL, '한 손으로 공을 잡고 다른 손 주먹으로 공을 쳐서 넘기는 서브를 배웁니다.', 3);

-- GAME (category 45)
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (39, 45, '미니 배구 게임', '3:3 미니 배구 경기', '5학년', NULL, '낮은 네트에서 3명씩 팀을 이루어 미니 배구 게임을 합니다.', 1);

-- =============================================
-- Activities for Unit 12 (6학년 운동체력)
-- =============================================
-- HOME (category 56)
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (40, 56, '버피 테스트', '버피 운동 도전하기', '6학년', '회', '서기 → 쪼그리기 → 팔굽혀펴기 → 쪼그리기 → 점프 순서로 수행합니다.', 1);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (41, 56, '홈 트레이닝', '집에서 하는 전신 운동', '6학년', '분', '스쿼트, 런지, 팔굽혀펴기, 플랭크를 각각 10회씩 3세트 수행합니다.', 2);

-- FITNESS (category 57)
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (42, 57, '1000m 달리기', '1000m 오래달리기', '6학년', '분', '운동장 트랙을 이용하여 1000m를 달립니다. 일정한 페이스를 유지하세요.', 1);

-- CLASS (category 58)
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (43, 58, '인터벌 트레이닝', '고강도 인터벌 운동', '6학년', NULL, '30초 전력 달리기 + 30초 걷기를 반복하는 인터벌 트레이닝을 합니다.', 1);

-- =============================================
-- Activities for Unit 13 (6학년 핸드볼)
-- =============================================
-- CLASS (category 63)
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (44, 63, '캐치볼', '핸드볼 캐치 연습', '6학년', NULL, '짝과 마주보고 핸드볼을 주고받는 캐치볼 연습을 합니다.', 1);
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (45, 63, '슈팅 연습', '골대를 향한 점프 슈팅', '6학년', NULL, '3보 스텝 후 점프하여 골대를 향해 슈팅합니다.', 2);

-- GAME (category 65)
INSERT INTO activities (id, category_id, name, description, target_grade, unit_label, guide_text, order_num) VALUES (46, 65, '미니 핸드볼 게임', '5:5 미니 핸드볼 경기', '6학년', NULL, '5명씩 팀을 이루어 미니 핸드볼 경기를 합니다.', 1);
