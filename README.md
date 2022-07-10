# Rozwiązanie zadania rekrutacyjnego
To repozytorium zawiera rozwiązanie zadania rekrutacyjnego. Stack: Java/Spring/MongoDB.
Wszystkie enpointy znajdują się na ścieżce `/api/proposal`.

Przykładowe requesty

`POST /api/proposal`

Body:
```json
{
    "title": "Proposal title",
    "content": "Proposal content."
}
```

`PUT /api/proposal/{id}/verify`

No body

`PUT /api/proposal/{id}/reject`

Body:
```json
{
    "comment": "Reject reason."
}
```

`PATCH /api/proposal/{id}/content`

Body:
```json
{
    "content": "New content"
}
```

`GET /api/proposal`

Query params
```
title: String, default null, optional
status: String, default null, optional
page: Integer, default 0, optional
size: Integer, default 10, optional
```
Response
```json
[
    {
        "id": "9b234f99-1eaf-4030-a8a6-322ade7e19d9",
        "publicationId": 5,
        "title": "Title",
        "content": "Content",
        "status": {
            "type": "PUBLISHED"
        },
        "history": [
            {
                "type": "CREATED"
            },
            {
                "type": "VERIFIED"
            },
            {
                "type": "ACCEPTED"
            }
        ]
    }
]
```
