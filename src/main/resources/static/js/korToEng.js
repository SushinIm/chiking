// Case 정리
// --------- 1 글자 ----------
// 1. ㄱ : 자음 
// 2. ㅏ : 모음
// --------- 2 글자 ----------
// 3. 자음 + 자음 : ㄺ
// 4. 자음 + 모음 : 가
// x. 모음 + 자음 : ㅗㄱ 
// 5. 모음 + 모음 : ㅚ 
// --------- 3 글자 ----------
// x. 자음 + 자음 + 자음 : ㄱㄱㄱ/ㄺㄱ/ㄱㄺ
// x. 자음 + 자음 + 모음 : ㄹ가
// 6. 자음 + 모음 + 자음 : 간
// 7. 자음 + 모음 + 모음 : 과/가ㅏ
// x. 모음 + 자음 + 자음 : ㅗㄱㄹ/ㅇㄺ
// x. 모음 + 자음 + 모음 : ㅗ고
// x. 모음 + 모음 + 자음 : ㅚㄱ/ㅏㅏㄱ
// x. 모음 + 모음 + 모음 : ㅏㅏㅏ/ㅚㅏ/ㅏㅚ
// --------- 4 글자 ----------
// 8. 자음 + 모음 + 자음 + 자음 : 닭
// 9. 자음 + 모음 + 모음 + 자음 : 관
// --------- 5 글자 ----------
// 10. 자음 + 모음 + 모음 + 자음 + 자음 : 괅 

var engType = "rRseEfaqQtTdwWczxvgkoiOjpuPhynbml";
var korType = "ㄱㄲㄴㄷㄸㄹㅁㅂㅃㅅㅆㅇㅈㅉㅊㅋㅌㅍㅎㅏㅐㅑㅒㅓㅔㅕㅖㅗㅛㅜㅠㅡㅣ";
var chosungs = "ㄱㄲㄴㄷㄸㄹㅁㅂㅃㅅㅆㅇㅈㅉㅊㅋㅌㅍㅎ";
var jungsungs = "ㅏㅐㅑㅒㅓㅔㅕㅖㅗㅘㅙㅚㅛㅜㅝㅞㅟㅠㅡㅢㅣ";
var jongsungs = "ㄱㄲㄳㄴㄵㄶㄷㄹㄺㄻㄼㄽㄾㄿㅀㅁㅂㅄㅅㅆㅇㅈㅊㅋㅌㅍㅎ";

function makeKor(src) {
  if (src == null) {
    return '';
  }
  var result = {
    usedWords : src.length
  }
  switch (src.length) {
  case 0:
    result.compKor = src;
    break;
  case 1: // case 1,2
    result.compKor = convertEK(src);
    break;
  case 2: // case 3,4,5
    var ch1 = src.charAt(0), ch2 = src.charAt(1);
    // 3. 자음 + 자음 : ㄺ
    if (isSon(ch1) && isSon(ch2)) {
      var fusionSon = sonFusion(convertEK(ch1), convertEK(ch2));
      if (fusionSon) {
        result.compKor = fusionSon;
      } else {
        result = makeKor(src.substring(1, 2));
      }
    }
    // 4. 자음 + 모음 : 가
    else if (isSon(ch1) && isMom(ch2)) {
      result.compKor = combineK(convertEK(ch1), convertEK(ch2));
    }
    // 5. 모음 + 모음 : ㅚ
    else if (isMom(ch1) && isMom(ch2)) {
      var fusionMom = momFusion(convertEK(ch1), convertEK(ch2));
      if (fusionMom) {
        result.compKor = fusionMom;
      } else {
        result = makeKor(src.substring(1, 2));
      }
    } else {
      result = makeKor(src.substring(1, 2));
    }
    break;
  case 3:// case 6, 7
    var ch1 = src.charAt(0), ch2 = src.charAt(1), ch3 = src.charAt(2);
    // 6. 자음 + 모음 + 자음 : 간
    if (isSon(ch1) && isMom(ch2) && isSon(ch3)) {
      result.compKor = combineK(convertEK(ch1), convertEK(ch2), convertEK(ch3));
    }
    // 7. 자음 + 모음 + 모음 : 과
    else if (isSon(ch1) && isMom(ch2) && isMom(ch3)) {
      var fusionMom = momFusion(convertEK(ch2), convertEK(ch3));
      if (fusionMom) {
        result.compKor = combineK(convertEK(ch1), fusionMom);
      } else {
        result = makeKor(src.substring(1, 3));
      }
    } else {
      result = makeKor(src.substring(1, 3));
    }
    break;
  case 4:// 
    var ch1 = src.charAt(0), ch2 = src.charAt(1), ch3 = src.charAt(2), ch4 = src.charAt(3);
    // 8. 자음 + 모음 + 자음 + 자음 : 닭
    if (isSon(ch1) && isMom(ch2) && isSon(ch3) && isSon(ch4)) {
      var fusionSon = sonFusion(convertEK(ch3), convertEK(ch4));
      if (fusionSon) {
        result.compKor = combineK(convertEK(ch1), convertEK(ch2), fusionSon);
      } else {
        result = makeKor(src.substring(1, 4));
      }
    }
    // 9. 자음 + 모음 + 모음 + 자음 : 관
    else if (isSon(ch1) && isMom(ch2) && isMom(ch3) && isSon(ch4)) {
      var fusionMom = momFusion(convertEK(ch2), convertEK(ch3));
      if (fusionMom) {
        result.compKor = combineK(convertEK(ch1), fusionMom, convertEK(ch4));
      } else {
        result = makeKor(src.substring(1, 4));
      }
    } else {
      result = makeKor(src.substring(1, 4));
    }
    break;
  case 5:// 
    var ch1 = src.charAt(0), ch2 = src.charAt(1), ch3 = src.charAt(2), ch4 = src.charAt(3), ch5 = src.charAt(4);
    // 자음 + 모음 + 모음 + 자음 + 자음 : 괅
    if (isSon(ch1) && isMom(ch2) && isMom(ch3) && isSon(ch4) && isSon(ch5)) {
      var fusionMom = momFusion(convertEK(ch2), convertEK(ch3));
      var fusionSon = sonFusion(convertEK(ch4), convertEK(ch5));
      if (fusionMom && fusionSon) {
        result.compKor = combineK(convertEK(ch1), fusionMom, fusionSon);
      } else {
        result = makeKor(src.substring(1, 5));
      }
    } else {
      result = makeKor(src.substring(1, 5));
    }
    break;
  }
  return result;
}
function korToEng(src) {
  var res = "";
  if (src.length == 0) {
    return res;
  }

  for (var i = 0; i < src.length; i++) {
    var ch = src.charAt(i);
    var nCode = ch.charCodeAt(0);
    var result = '';
    var chosung, jungshung, jongsung;
    if (44032 <= nCode && nCode <= 55203) {
      nCode -= 44032;
      chosung = chosungs.charAt(Math.floor(nCode / (21 * 28)));
      jungsung = jungsungs.charAt(Math.floor(nCode / 28) % 21);
      jongsung = jongsungs.charAt(nCode % 28 - 1);
      res += convertKE(chosung);
      var momSlice = doMomSlice(jungsung);
      if (momSlice) {
        res += convertKE(momSlice);
      } else {
        res += convertKE(jungsung);
      }
      var sonSlice = doSonSlice(jongsung);
      if (sonSlice) {
        res += convertKE(sonSlice);
      } else {
        res += convertKE(jongsung);
      }
    } else if (chosungs.indexOf(ch) > -1) {
      res += convertKE(ch);
    } else if (jungsungs.indexOf(ch) > -1) {
      var momSlice = doMomSlice(ch);
      if (momSlice) {
        res += convertKE(momSlice);
      } else {
        res += convertKE(ch);
      }
    } else if (jongsungs.indexOf(ch) > -1) {
      var sonSlice = doSonSlice(ch);
      if (sonSlice) {
        res += convertKE(sonSlice);
      } else {
        res += convertKE(ch);
      }
    } else {
      res += ch;
    }
  }

  return res;
}

function convertEK(src) {
  var result = '';
  for (var i = 0; i < src.length; i++) {
    var ch = src.charAt(i);
    var index = engType.indexOf(ch);
    if (index >= 0) {
      result += korType.charAt(index);
    } else {
      result += ch;
    }
  }
  return result;
}
function convertKE(src) {
  var result = '';
  for (var i = 0; i < src.length; i++) {
    var ch = src.charAt(i);
    var index = korType.indexOf(ch);
    if (index >= 0) {
      result += engType.charAt(index);
    } else {
      result += ch;
    }
  }
  return result;
}
function isengType(ch) {
  return engType.indexOf(ch) >= 0;
}
function isMom(ch) {
  return engType.indexOf(ch) >= 19;
}
function isSon(ch) {
  return engType.indexOf(ch) < 19 && engType.indexOf(ch) >= 0;
}
function engToKor(src) {
  var res = "";
  if (src.length == 0)
    return res;
  var chosungPos = -1, jungsungPos = -1, jongsungPos = -1; // chosung, jungsung, jongsung
  for (var i = 0; i < src.length; i++) {
    var result = makeKor(src.slice(Math.max(src.length - 5 - i, 0), src.length - i));
    // console.log(result);
    i += result.usedWords - 1;
    res = result.compKor + res;
  }
  return res;
}

function combineK(chosung, jungsung, jongsung) {
  return String.fromCharCode(44032 + chosungs.indexOf(chosung) * 21 * 28 + jungsungs.indexOf(jungsung) * 28 + jongsungs.indexOf(jongsung) + 1);
}
function momFusion(ch1, ch2) {
  var result = null;
  if (ch1 == 'ㅗ' && ch2 == 'ㅏ') { // ㅘ
    result = 'ㅘ';
  } else if (ch1 == 'ㅗ' && ch2 == 'ㅐ') { // ㅙ
    result = 'ㅙ';
  } else if (ch1 == 'ㅗ' && ch2 == 'ㅣ') { // ㅚ
    result = 'ㅚ';
  } else if (ch1 == 'ㅜ' && ch2 == 'ㅓ') { // ㅝ
    result = 'ㅝ';
  } else if (ch1 == 'ㅜ' && ch2 == 'ㅔ') { // ㅞ
    result = 'ㅞ';
  } else if (ch1 == 'ㅜ' && ch2 == 'ㅣ') { // ㅟ
    result = 'ㅟ';
  } else if (ch1 == 'ㅡ' && ch2 == 'ㅣ') { // ㅢ
    result = 'ㅢ';
  }
  return result;
}
function doMomSlice(ch) {
  switch (ch) {
  case 'ㅘ':
    return 'ㅗㅏ';
  case 'ㅙ':
    return 'ㅗㅐ';
  case 'ㅚ':
    return 'ㅗㅣ';
  case 'ㅝ':
    return 'ㅜㅓ';
  case 'ㅞ':
    return 'ㅜㅔ';
  case 'ㅟ':
    return 'ㅜㅣ';
  case 'ㅢ':
    return 'ㅡㅣ';
  }
  return null;
}
function sonFusion(ch1, ch2) {
  var result = null;
  if (ch1 == 'ㄱ' && ch2 == 'ㅅ') { // ㄳ
    result = 'ㄳ';
  } else if (ch1 == 'ㄴ' && ch2 == 'ㅈ') { // ㄵ
    result = 'ㄵ';
  } else if (ch1 == 'ㄴ' && ch2 == 'ㅎ') { // ㄶ
    result = 'ㄶ';
  } else if (ch1 == 'ㄹ' && ch2 == 'ㄱ') { // ㄺ
    result = 'ㄺ';
  } else if (ch1 == 'ㄹ' && ch2 == 'ㅁ') { // ㄻ
    result = 'ㄻ';
  } else if (ch1 == 'ㄹ' && ch2 == 'ㅂ') { // ㄼ
    result = 'ㄼ';
  } else if (ch1 == 'ㄹ' && ch2 == 'ㅅ') { // ㄽ
    result = 'ㄽ';
  } else if (ch1 == 'ㄹ' && ch2 == 'ㅌ') { // ㄾ
    result = 'ㄾ';
  } else if (ch1 == 'ㄹ' && ch2 == 'ㅍ') { // ㄿ
    result = 'ㄿ';
  } else if (ch1 == 'ㄹ' && ch2 == 'ㅎ') { // ㅀ
    result = 'ㅀ';
  } else if (ch1 == 'ㅂ' && ch2 == 'ㅅ') { // ㅄ
    result = 'ㅄ';
  }
  return result;
}
function doSonSlice(ch) {
  switch (ch) {
  case 'ㄳ':
    return 'ㄱㅅ';
  case 'ㄵ':
    return 'ㄴㅈ';
  case 'ㄶ':
    return 'ㄴㅎ';
  case 'ㄺ':
    return 'ㄹㄱ';
  case 'ㄻ':
    return 'ㄹㅁ';
  case 'ㄼ':
    return 'ㄹㅂ';
  case 'ㄽ':
    return 'ㄹㅅ';
  case 'ㄾ':
    return 'ㄹㅌ';
  case 'ㄿ':
    return 'ㄹㅍ';
  case 'ㅀ':
    return 'ㄹㅎ';
  case 'ㅄ':
    return 'ㅂㅅ';
  }
  return null;
}