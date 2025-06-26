# Tracking Number Generator API

## Endpoint
`GET /next-tracking-number`

### Query Params
- `origin_country_id`: e.g., "PH"
- `destination_country_id`: e.g., "MY"
- `weight`: e.g., "1.234"
- `created_at`: RFC 3339 format
- `customer_id`: UUID
- `customer_name`: string
- `customer_slug`: string

## Example Request
GET /next-tracking-number?origin_country_id=PH&destination_country_id=MY&weight=1.234&created_at=2025-06-26T14:30:00%2B08:00&customer_id=de619854-b59b-425e-9db4-943979e1bd49&customer_name=RedBox Logistics&customer_slug=redbox-logistics

## Response
```json
{
  "tracking_number": "F4A2D31E98F1C1",
  "created_at": "2025-06-25T14:34:12+08:00"
}